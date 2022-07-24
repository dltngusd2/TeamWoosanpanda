package com.woosan.root.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.woosan.root.service.ChatService;
import com.woosan.root.service.TradeBoardService;
import com.woosan.root.dto.ChatMessage;
import com.woosan.root.dto.ChatRoom;
import com.woosan.root.dto.ChatSession;
import com.woosan.root.dto.TradeBoardDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
 
@Controller
public class ChatController {
    
    @Autowired
    ChatService cService;
    
    @Autowired
    TradeBoardService tbs;
    
    @Autowired
    private ChatSession cSession;
    
    /**
     * �ش� ä�ù��� ä�� �޼��� �ҷ�����
     * @param roomId
     * @param model
     * @param response
     * @throws JsonIOException
     * @throws IOException
     */
    @RequestMapping(value="{roomId}.do")
    public void messageList(@PathVariable String roomId, String id, Model model, HttpServletResponse response) throws JsonIOException, IOException {
        
        List<ChatMessage> mList = cService.messageList(roomId);
        response.setContentType("application/json; charset=utf-8");
 
        // ������ �޼����� ���� 0���� �ٲ��
        ChatMessage message = new ChatMessage();
        message.setId(id);
        message.setRoomId(roomId);
        cService.updateCount(message);
        
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(mList,response.getWriter());
    }
    
    /**
     * ä�� ���� ���� �� ����
     * @param room
     * @param userEmail
     * @param masterNickname
     * @return
     */
    @ResponseBody
    @RequestMapping("createChat.do")
    public String createChat(ChatRoom room, String userName, String masterNickname){
        
        TradeBoardDTO m = tbs.chatSetup(masterNickname);
    
        room.setUserName(userName);
        room.setMasterName(m.getId());
        room.setMasterPic(m.getImg_addr());
 
        ChatRoom exist  = cService.searchChatRoom(room);
        
        // DB�� ���� ���� ��
        if(exist == null) {
            System.out.println("���� ����!!");
            int result = cService.createChat(room);
            if(result == 1) {
                System.out.println("�� �������!!");
                return "new";
            }else {
                return "fail";
            }
        }
        // DB�� ���� ���� ��
        else{
            System.out.println("���� �ִ�!!");
            return "exist";
        }
    }
    
    /**
     * ä�� �� ��� �ҷ�����
     * @param room
     * @param userEmail
     * @param response
     * @throws JsonIOException
     * @throws IOException
     */
    @RequestMapping("chatRoomList.do")
    public void createChat(ChatRoom room, ChatMessage message, String id, HttpServletResponse response) throws JsonIOException, IOException{
        List<ChatRoom> cList = cService.chatRoomList(id);
        
        for(int i = 0; i < cList.size(); i++) {
            message.setRoomId(cList.get(i).getRoomId());
            message.setId(id);
            int count = cService.selectUnReadCount(message);
            cList.get(i).setUnReadCount(count);
        }
        
        response.setContentType("application/json; charset=utf-8");
 
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(cList,response.getWriter());
    }
    
    @RequestMapping("chatSession.do")
    public void chatSession( HttpServletResponse response) throws JsonIOException, IOException{
        
        ArrayList<String> chatSessionList = cSession.getLoginUser();
        
        response.setContentType("application/json; charset=utf-8");
 
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        gson.toJson(chatSessionList,response.getWriter());
    }
    
    @GetMapping("talk")
    public String talk() {
    	return "talk";
    }
    
}