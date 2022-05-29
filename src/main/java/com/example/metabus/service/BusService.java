package com.example.metabus.service;

import com.example.metabus.persistence.dao.BusDao;
import com.example.metabus.persistence.dao.BusDaoImpl;
import com.example.metabus.persistence.domain.BusNumber;
import com.example.metabus.persistence.domain.BusStation;
import com.example.metabus.persistence.domain.Facility;
import com.example.metabus.service.FacilityService;
import com.example.metabus.persistence.dao.FacilityDao;
import com.example.metabus.persistence.dao.FacilityDaoImpl;

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

    public List<BusStation> getAroundBusStation(String name){
        FacilityService facilityService = new FacilityService();
        Facility facility = facilityService.getFacility(name).get(0);
        double lat = facility.getLatitude(), lng = facility.getLongitude();
        List<BusStation> busStations = new ArrayList<>();
        busStations = busDao.getAroundBusStationByLatitudeAndLongitude(lat, lng);
        return busStations;
    }

}


