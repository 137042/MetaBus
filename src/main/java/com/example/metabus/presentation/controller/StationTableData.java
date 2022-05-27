package com.example.metabus.presentation.controller;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;

public class StationTableData {

    private IntegerProperty stationId;
    private StringProperty stationName;
    private CheckBox checkBox;

    public StationTableData(IntegerProperty stationId, StringProperty stationName) {
        checkBox = new CheckBox();
        this.stationId = stationId;
        this.stationName = stationName;
    }

    public IntegerProperty getStationId() {
        return stationId;
    }

    public StringProperty getStationName() {
        return stationName;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setStationId(IntegerProperty sid){
        stationId = sid;
    }

    public void setStationName(StringProperty sn) {
        stationName = sn;
    }

    public void setCheckBox(CheckBox cb){
        checkBox = cb;
    }

}
