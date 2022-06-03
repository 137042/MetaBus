package com.example.metabus.persistence.domain;

public class User {

    private int privateId;
    private String name;
    private String loginId;
    private String loginPassword;
    private int groupId;

    public User() {

    }

    public User(String name, String loginId, String loginPassword) {
        this.name = name;
        this.loginId = loginId;
        this.loginPassword = loginPassword;

    }

    public int getPrivateId() {
        return privateId;
    }

    public void setPrivateId(int privateId) {
        this.privateId = privateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
