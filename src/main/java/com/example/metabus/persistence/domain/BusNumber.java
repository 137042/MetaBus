package com.example.metabus.persistence.domain;

import java.sql.Time;

public class BusNumber {

    private int privateId;
    private String busNumber;
    private String busType;
    private Time startTime;
    private Time endTime;
    private String startStation;
    private String endStation;
    private int routeId;

    public BusNumber(){

    }

    public BusNumber(int privateId, String busNumber, String busType, Time startTime, Time endTime, String startStation, String endStation, int routeId) {
        this.privateId = privateId;
        this.busNumber = busNumber;
        this.busType = busType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startStation = startStation;
        this.endStation = endStation;
        this.routeId = routeId;
    }

    public int getPrivateId() {
        return privateId;
    }

    public void setPrivateId(int privateId) {
        this.privateId = privateId;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }
}
