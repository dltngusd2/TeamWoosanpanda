package com.woosan.root.mapper;

import java.util.List;

import com.woosan.root.dto.ChatMessage;
import com.woosan.root.dto.ChatRoom;

public interface ChatMapper {
	public void createChat(ChatRoom room);
	public ChatRoom selectChatRoom(String roomId);
	public void insertMessage(ChatMessage chatMessage);
	public List<ChatMessage> messageList(String roomId);
	public ChatRoom searchChatRoom(ChatRoom room);
	public List<ChatRoom> chatRoomList(String id);
	public int selectUnReadCount(ChatMessage chatMessage);
	public int updateCount(ChatMessage chatMessage);
}
