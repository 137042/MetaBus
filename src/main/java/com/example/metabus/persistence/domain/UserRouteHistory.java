package com.example.metabus.persistence.domain;

public class UserRouteHistory {

    private int privateId;
    private User userId;
    private int startStationId;
    private int arrivalStationId;
    private int count;

    public UserRouteHistory() {

    }

    public UserRouteHistory(int privateId, User userId, int startStationId, int arrivalStationId, int count) {
        this.privateId = privateId;
        this.userId = userId;
        this.startStationId = startStationId;
        this.arrivalStationId = arrivalStationId;
        this.count = count;
    }

    public int getPrivateId() {
        return privateId;
    }

    public void setPrivateId(int privateId) {
        this.privateId = privateId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public int getStartStationId() {
        return startStationId;
    }

    public void setStartStationId(int startStationId) {
        this.startStationId = startStationId;
    }

    public int getArrivalStationId() {
        return arrivalStationId;
    }

    public void setArrivalStationId(int arrivalStationId) {
        this.arrivalStationId = arrivalStationId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
