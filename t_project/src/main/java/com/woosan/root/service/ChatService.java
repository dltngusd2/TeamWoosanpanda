package com.woosan.root.service;

import java.util.List;

import com.woosan.root.dto.ChatMessage;
import com.woosan.root.dto.ChatRoom;
 
public interface ChatService {
 
    /**
     * �� ��ȣ�� �����ϴ� �޼ҵ�
     * @param roomId
     * @return
     */
    ChatRoom selectChatRoom(String roomId);
 
    /**
     * ä�� �޼��� DB ����
     * @param chatMessage
     * @return 
     */
    int insertMessage(ChatMessage chatMessage);
 
    /**
     * �޼��� ���� ����Ʈ ���
     * @param roomId
     * @return
     */
    List<ChatMessage> messageList(String roomId);
 
    /**
     * ä�� �� DB ����
     * @param room
     * @return
     */
    int createChat(ChatRoom room);
 
    /**
     * DB�� ä�� ���� �ִ��� Ȯ��
     * @param room
     * @return
     */
    ChatRoom searchChatRoom(ChatRoom room);
 
    /**
     * ä�� �� ����Ʈ ���
     * @param userEmail
     * @return
     */
    List<ChatRoom> chatRoomList(String id);
 
    /**
     * ä�� ���� ���� �޼��� �� ���
     * @param message
     * @return
     */
    int selectUnReadCount(ChatMessage message);
 
    /**
     * ���� �޼��� ���� 0���� �ٲٱ�
     * @param message
     * @return
     */
    int updateCount(ChatMessage message);
 
}