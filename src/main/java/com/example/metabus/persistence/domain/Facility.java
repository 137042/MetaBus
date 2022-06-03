package com.example.metabus.persistence.domain;

import java.util.List;

public class Facility {
    private int privateId;
    private String name;
    private String address;
    private double latitude;
    private double longitude;

    public Facility() {

    }

    public Facility(int privateId, String name, String address, double latitude, double longitude, List<UserFacilityHistory> userFacilityHistories) {
        this.privateId = privateId;
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.userFacilityHistories = userFacilityHistories;
    }

    private List<UserFacilityHistory> userFacilityHistories;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<UserFacilityHistory> getUserFacilityHistories() {
        return userFacilityHistories;
    }

    public void setUserFacilityHistories(List<UserFacilityHistory> userFacilityHistories) {
        this.userFacilityHistories = userFacilityHistories;
    }
}
