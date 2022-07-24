package com.woosan.root.websocket;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
 
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
 
import com.fasterxml.jackson.databind.ObjectMapper;
import com.woosan.root.service.ChatService;
import com.woosan.root.dto.ChatMessage;
import com.woosan.root.dto.ChatRoom;
 
@Controller
public class WebSocketHandler extends TextWebSocketHandler implements InitializingBean {
    
    @Autowired
    ChatService cService;
    
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    // ä�ù� ��� <�� ��ȣ, ArrayList<session> >�� ����.
    private Map<String, ArrayList<WebSocketSession>> RoomList = new ConcurrentHashMap<String, ArrayList<WebSocketSession>>();
    // session, �� ��ȣ�� ����.
    private Map<WebSocketSession, String> sessionList = new ConcurrentHashMap<WebSocketSession, String>();
    
    private static int i;
    /**
     * websocket ���� ���� ��
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        i++;
        System.out.println(session.getId() + " ���� ���� => �� ���� �ο� : " + i + "��");
    }
 
    /**
     * websocket ���� ���� ��
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        i--;
        System.out.println(session.getId() + " ���� ���� => �� ���� �ο� : " + i + "��");
        // sessionList�� session�� �ִٸ�
        if(sessionList.get(session) != null) {
            // �ش� session�� �� ��ȣ�� �����ͼ�, ���� ã��, �� ���� ArrayList<session>���� �ش� session�� �����.
            RoomList.get(sessionList.get(session)).remove(session);
            sessionList.remove(session);
        }
    }
 
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
 
        // ���޹��� �޼���
        String msg = message.getPayload();
        
        // Json��ü �� Java��ü
        // ��°� : [roomId=123, messageId=null, message=asd, name=õ����, email=cheon@gmail.com, unReadCount=0]
        ChatMessage chatMessage = objectMapper.readValue(msg,ChatMessage.class);
        
        // ���� �޼����� ��� roomId�� �ش� ä�ù��� ã�ƿ´�.
        ChatRoom chatRoom = cService.selectChatRoom(chatMessage.getRoomId());
        
        // ä�� ���� ��Ͽ� ä�ù��� �������� �ʰ�, ó�� ���԰�, DB������ ä�ù��� ���� ��
        // ä�ù� ����
        if(RoomList.get(chatRoom.getRoomId()) == null && chatMessage.getMessage().equals("ENTER-CHAT") && chatRoom != null) {
            
            // ä�ù濡 �� session��
            ArrayList<WebSocketSession> sessionTwo = new ArrayList<>();
            // session �߰�
            sessionTwo.add(session);
            // sessionList�� �߰�
            sessionList.put(session, chatRoom.getRoomId());
            // RoomList�� �߰�
            RoomList.put(chatRoom.getRoomId(), sessionTwo);
            // Ȯ�ο�
            System.out.println("ä�ù� ����");
        }
        
        // ä�ù��� ���� �� ��
        else if(RoomList.get(chatRoom.getRoomId()) != null && chatMessage.getMessage().equals("ENTER-CHAT") && chatRoom != null) {
            
            // RoomList���� �ش� ���ȣ�� ���� ���� �ִ��� Ȯ��.
            RoomList.get(chatRoom.getRoomId()).add(session);
            // sessionList�� �߰�
            sessionList.put(session, chatRoom.getRoomId());
            // Ȯ�ο�
            System.out.println("������ ä�ù����� ����");
        }
        
        // ä�� �޼��� �Է� ��
        else if(RoomList.get(chatRoom.getRoomId()) != null && !chatMessage.getMessage().equals("ENTER-CHAT") && chatRoom != null) {
            
            // �޼����� �̸�, �̸���, ������ ��´�.
            TextMessage textMessage = new TextMessage(chatMessage.getId() + "," + chatMessage.getMessage());
            
            // ���� session ��
            int sessionCount = 0;
 
            // �ش� ä�ù��� session�� �ѷ��ش�.
            for(WebSocketSession sess : RoomList.get(chatRoom.getRoomId())) {
                sess.sendMessage(textMessage);
                sessionCount++;
            }
            
            // ������������ ����� sessionCount ����
            // sessionCount == 2 �� ���� unReadCount = 0,
            // sessionCount == 1 �� ���� unReadCount = 1
            chatMessage.setSessionCount(sessionCount);
            
            // DB�� �����Ѵ�.
            int a = cService.insertMessage(chatMessage);
            
            if(a == 1) {
                System.out.println("�޼��� ���� �� DB ���� ����");
            }else {
                System.out.println("�޼��� ���� ����!!! & DB ���� ����!!");
            }
        }
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {}
}
