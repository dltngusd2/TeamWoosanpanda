package com.woosan.root.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
 
@Component("cSession")
public class ChatSession {
    
    // static���� �ʵ庯���� �����Ͽ� ���� ArrayList�� �̿� �� �� �ֵ��� �����մϴ�.
    private static ArrayList<String> loginUser = new ArrayList<String>();
    
    // �α��� �� ArrayList�� �߰��մϴ�.
    public void addLoginUser(String id) {
        loginUser.add(id);
    }
    
    // �α׾ƿ� �� ArrayList���� �����մϴ�.
    public void removeLoginUser(String id) {
        loginUser.remove(id);
    }
 
    // ���� �α��� �Ǿ� �ִ� ���� ����� �����ɴϴ�.
    public static ArrayList<String> getLoginUser() {
        return loginUser;
    }
 
    // �ڵ� setter. ������� �ʾҽ��ϴ�.
    public static void setLoginUser(ArrayList<String> loginUser) {
        ChatSession.loginUser = loginUser;
    }
}
