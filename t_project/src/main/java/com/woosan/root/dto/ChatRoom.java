package com.woosan.root.dto;

public class ChatRoom {
    
    private String roomId;        // 방 번호
    
    private String userName;    // 사용자 이름
    private String userPic;        // 사용자 사진
    
    private String masterName;    // 상대방 이름
    private String masterPic;    // 상대방 사진
    
    private int unReadCount;    // 안 읽은 메세지 수
    
    public ChatRoom() {
        super();
    }
 
    public ChatRoom(String roomId, String userEmail, String userName, String userPic, String masterEmail,
            String masterName, String masterPic, int unReadCount) {
        super();
        this.roomId = roomId;
        this.userName = userName;
        this.userPic = userPic;
        this.masterName = masterName;
        this.masterPic = masterPic;
        this.unReadCount = unReadCount;
    }
 
    public String getRoomId() {
        return roomId;
    }
 
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
 
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getUserPic() {
        return userPic;
    }
 
    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }
 
    public String getMasterName() {
        return masterName;
    }
 
    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }
 
    public String getMasterPic() {
        return masterPic;
    }
 
    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }
 
    public int getUnReadCount() {
        return unReadCount;
    }
 
    public void setUnReadCount(int unReadCount) {
        this.unReadCount = unReadCount;
    }
 
    @Override
    public String toString() {
        return "ChatRoom [roomId=" + roomId + ", userName=" + userName + ", userPic="
                + userPic + ", masterName=" + masterName + ", masterPic=" + masterPic
                + ", unReadCount=" + unReadCount + "]";
    }
}