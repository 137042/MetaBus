package com.example.metabus.controller;

import javafx.beans.property.StringProperty;

public class FacilityTableData {

    private StringProperty group;
    private StringProperty name;
    private StringProperty address;

    public FacilityTableData(StringProperty g, StringProperty n, StringProperty a) {
        this.group = g;
        this.name = n;
        this.address = a;
    }

    public StringProperty getGroup(){
        return group;
    }

    public StringProperty getName(){
        return name;
    }

    public StringProperty getAddress(){
        return address;
    }

}
