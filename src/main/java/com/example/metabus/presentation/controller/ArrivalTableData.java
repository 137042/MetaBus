package com.example.metabus.presentation.controller;

import javafx.beans.property.StringProperty;

public class ArrivalTableData {

    private StringProperty bus;
    private StringProperty schedule;
    private StringProperty currentStop;
    private StringProperty leftTime;

    public ArrivalTableData(StringProperty bus, StringProperty schedule, StringProperty currentStop, StringProperty leftTime) {
        this.bus = bus;
        this.schedule = schedule;
        this.currentStop = currentStop;
        this.leftTime = leftTime;
    }

    public StringProperty getBus() {
        return bus;
    }

    public StringProperty getSchedule() {
        return schedule;
    }

    public StringProperty getCurrentStop() {
        return currentStop;
    }

    public StringProperty getLeftTime() {
        return leftTime;
    }
}