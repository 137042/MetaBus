package com.example.metabus.service;

import com.example.metabus.persistence.dao.BusDao;
import com.example.metabus.persistence.dao.BusDaoImpl;
import com.example.metabus.persistence.domain.BusNumber;
import com.example.metabus.persistence.domain.BusStation;

import java.util.ArrayList;
import java.util.List;

public class BusService {
    BusDao busDao = null;

    public BusService() {
        busDao = new BusDaoImpl();
    }

    public List<BusStation> getAroundBusStation(double latitude, double longitude) {
        List<BusStation> busStations = new ArrayList<>();
        busStations = busDao.getAroundBusStationByLatitudeAndLongitude(latitude, longitude);
        return busStations;
    }

    public List<BusNumber> getLayOverBus(int departStationNumb, int arrivalStationNumb){
        List<BusNumber> busNumbers = new ArrayList<>();
        busNumbers = busDao.getLayOverBus(departStationNumb, arrivalStationNumb);
        return busNumbers;
    }


}


