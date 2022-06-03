package com.example.metabus.persistence.domain;

import java.sql.Time;

public class BusTime {
    private int busRouteId;
    private Time departureTime;
    private int dispatchOrder;
    private Boolean isWeekend;

    public BusTime() {

    }

    public BusTime(int busRouteId, Time departureTime, int dispatchOrder, Boolean isWeekend) {
        this.busRouteId = busRouteId;
        this.departureTime = departureTime;
        this.dispatchOrder = dispatchOrder;
        this.isWeekend = isWeekend;
    }

    public int getBusRouteId() {
        return busRouteId;
    }

    public void setBusRouteId(int busRouteId) {
        this.busRouteId = busRouteId;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public int getDispatchOrder() {
        return dispatchOrder;
    }

    public void setDispatchOrder(int dispatchOrder) {
        this.dispatchOrder = dispatchOrder;
    }

    public Boolean getWeekend() {
        return isWeekend;
    }

    public void setWeekend(Boolean weekend) {
        isWeekend = weekend;
    }
}
