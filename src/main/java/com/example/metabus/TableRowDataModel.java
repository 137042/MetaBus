package com.example.metabus;

import javafx.beans.property.StringProperty;

public class TableRowDataModel {
    private StringProperty bus;
    private StringProperty schedule;
    private StringProperty cur_stop;
    private StringProperty left;

    public TableRowDataModel(StringProperty bus, StringProperty schedule, StringProperty cur_stop, StringProperty left) {
        this.bus = bus;
        this.schedule = schedule;
        this.cur_stop = cur_stop;
        this.left = left;
    }

    public StringProperty getBus() {
        return bus;
    }
    public StringProperty getSchedule() {
        return schedule;
    }
    public StringProperty getCur_stop() {
        return cur_stop;
    }
    public StringProperty getLeft() {
        return left;
    }
}