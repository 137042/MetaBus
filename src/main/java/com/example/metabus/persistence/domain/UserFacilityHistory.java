package com.example.metabus.persistence.domain;

public class UserFacilityHistory {

    private int privateId;
    private Facility facility;
    private User user;
    private int count;

    public UserFacilityHistory() {

    }

    public UserFacilityHistory(Facility facility, User user, int count) {
        this.facility = facility;
        this.user = user;
        this.count = count;
    }

    public int getPrivateId() {
        return privateId;
    }

    public void setPrivateId(int privateId) {
        this.privateId = privateId;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
