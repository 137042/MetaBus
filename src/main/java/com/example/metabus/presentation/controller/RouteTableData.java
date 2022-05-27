package com.example.metabus.presentation.controller;

import javafx.beans.property.StringProperty;

public class RouteTableData {

    private StringProperty startSt;
    private StringProperty endSt;

    public RouteTableData(StringProperty sst, StringProperty est) {
        startSt = sst;
        endSt = est;
    }

    public StringProperty getStartSt(){
        return startSt;
    }

    public StringProperty getEndSt(){
        return endSt;
    }

    public void setStartSt(StringProperty ss){
        startSt = ss;
    }

    public void setEndSt(StringProperty es){
        endSt = es;
    }

}
