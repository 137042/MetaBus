package com.example.metabus.persistence.domain;

public class BusStation {

    private int privateId;
    private int apiId;
    private int serviceId;
    private String name;
    private double latitude;
    private double longitude;

    public BusStation() {

    }

    public BusStation(int privateId, int serviceId, String name, double latitude, double longitude) {
        this.privateId = privateId;
        this.serviceId = serviceId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getPrivateId() {
        return privateId;
    }

    public void setPrivateId(int privateId) {
        this.privateId = privateId;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
