package com.woosan.root.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.woosan.root.dto.ChatMessage;
import com.woosan.root.dto.ChatRoom;
import com.woosan.root.mapper.ChatMapper;

public class ChatServiceImpl implements ChatService {
	@Autowired ChatMapper cm;
	@Override
	public ChatRoom selectChatRoom(String roomId) {
		return cm.selectChatRoom(roomId);
	}

	@Override
	public int insertMessage(ChatMessage chatMessage) {
		cm.insertMessage(chatMessage);
		return 0;
	}

	@Override
	public List<ChatMessage> messageList(String roomId) {
		return cm.messageList(roomId);
	}

	@Override
	public int createChat(ChatRoom room) {
		cm.createChat(room);
		return 1;
	}

	@Override
	public ChatRoom searchChatRoom(ChatRoom room) {
		return cm.searchChatRoom(room);
	}

	@Override
	public List<ChatRoom> chatRoomList(String id) {
		return cm.chatRoomList(id);
	}

	@Override
	public int selectUnReadCount(ChatMessage message) {
		return cm.selectUnReadCount(message);
	}

	@Override
	public int updateCount(ChatMessage message) {
		message.setUnReadCount(0);
		cm.updateCount(message);
		return 0;
	}

}
