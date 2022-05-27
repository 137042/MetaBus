package com.example.metabus.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String name;
    private String loginId;
    private String loginPassword;
    private int groupId;



    public User(String name, String loginId, String loginPassword) {
        this.name = name;
        this.loginId = loginId;
        this.loginPassword = loginPassword;
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

    public String getLoginPassword(){return loginPassword;}

    public int getGroup_id() {
        return groupId;
    }

    public void setGroup_id(int group_id) {
        this.groupId = group_id;
    }
}
