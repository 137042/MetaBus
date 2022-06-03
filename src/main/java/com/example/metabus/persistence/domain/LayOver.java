package com.example.metabus.persistence.domain;

public class LayOver {

    private BusNumber busRouteId;
    private BusStation stationId;
    private int order;

    public LayOver() {

    }

    public LayOver(BusNumber busRouteId, BusStation stationId, int order) {
        this.busRouteId = busRouteId;
        this.stationId = stationId;
        this.order = order;
    }

    public BusNumber getBusRouteId() {
        return busRouteId;
    }

    public void setBusRouteId(BusNumber busRouteId) {
        this.busRouteId = busRouteId;
    }

    public BusStation getStationId() {
        return stationId;
    }

    public void setStationId(BusStation stationId) {
        this.stationId = stationId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
