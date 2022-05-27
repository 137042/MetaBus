package com.example.metabus.presentation.controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class ArrivalTableData {

    private IntegerProperty startStation;
    private IntegerProperty endStation;
    private StringProperty bus;
    private IntegerProperty leftTime;

    public ArrivalTableData(IntegerProperty startStation, IntegerProperty endStation, StringProperty bus, IntegerProperty leftTime) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.bus = bus;
        this.leftTime = leftTime;
    }

    public IntegerProperty getStartStation() {
        return startStation;
    }

    public IntegerProperty getEndStation() {
        return endStation;
    }

    public StringProperty getBus() {
        return bus;
    }

    public IntegerProperty getLeftTime() {
        return leftTime;
    }

    public void setStartStation(IntegerProperty ss){
        startStation = ss;
    }

    public void setEndStation(IntegerProperty es) {
        endStation = es;
    }

    public void setBus(StringProperty b){
        bus = b;
    }

    public void setLeftTime(IntegerProperty lt){
        leftTime = lt;
    }

}