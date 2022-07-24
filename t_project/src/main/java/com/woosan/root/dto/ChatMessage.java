package com.woosan.root.dto;

public class ChatMessage {
    
    private String roomId;            // 방 번호
    private String messageId;        // 메세지 번호
    private String message;            // 메세지 내용
    private String id;            // 보낸이 이름
    private int unReadCount;        // 안 읽은 메세지 수
    private int sessionCount;        // 현재 세션 수
    
    public ChatMessage() {
        super();
    }
 
    public ChatMessage(String roomId, String messageId, String message, String id, int unReadCount,
            int sessionCount) {
        super();
        this.roomId = roomId;
        this.messageId = messageId;
        this.message = message;
        this.id = id;
        this.unReadCount = unReadCount;
        this.sessionCount = sessionCount;
    }
 
    public String getRoomId() {
        return roomId;
    }
 
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
 
    public String getMessageId() {
        return messageId;
    }
 
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public int getUnReadCount() {
        return unReadCount;
    }
 
    public void setUnReadCount(int unReadCount) {
        this.unReadCount = unReadCount;
    }
 
    public int getSessionCount() {
        return sessionCount;
    }
 
    public void setSessionCount(int sessionCount) {
        this.sessionCount = sessionCount;
    }
 
    @Override
    public String toString() {
        return "ChatMessage [roomId=" + roomId + ", messageId=" + messageId + ", message=" + message + ", id=" + id
                + ", unReadCount=" + unReadCount + ", sessionCount=" + sessionCount + "]";
    }
}
