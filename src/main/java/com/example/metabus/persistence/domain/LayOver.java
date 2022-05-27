package com.example.metabus.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class LayOver {

    private BusNumber busRouteId;
    private BusStation stationId;
    private int order;



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
