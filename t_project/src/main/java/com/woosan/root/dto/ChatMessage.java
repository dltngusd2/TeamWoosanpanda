package com.woosan.root.dto;

public class ChatMessage {
    
    private String roomId;            // �� ��ȣ
    private String messageId;        // �޼��� ��ȣ
    private String message;            // �޼��� ����
    private String id;            // ������ �̸�
    private int unReadCount;        // �� ���� �޼��� ��
    private int sessionCount;        // ���� ���� ��
    
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
