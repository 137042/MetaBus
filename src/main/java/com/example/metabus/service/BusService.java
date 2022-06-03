package com.example.metabus.service;

import com.example.metabus.persistence.dao.BusDao;
import com.example.metabus.persistence.dao.BusDaoImpl;
import com.example.metabus.persistence.domain.BusNumber;
import com.example.metabus.persistence.domain.BusStation;
import com.example.metabus.persistence.domain.Facility;
import org.apache.ibatis.annotations.Param;

import java.util.*;

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

    public List<BusNumber> getLayOverBusFromDepartureToArrival(String departStation, String arrivalStation) {
        List<BusNumber> LayOverBus = new ArrayList<>();
        LayOverBus = busDao.getLayOverBus(departStation, arrivalStation);
        for(int i = 0; i <= LayOverBus.size(); i++){
            System.out.println(LayOverBus.get(i).getBusNumber());
        }
        return LayOverBus;

    }
        public List<BusNumber> getDirectBusFromDepartureToArrival(int service_id1, int service_id2){
        List<BusNumber> directBus = new ArrayList<>();
        directBus = busDao.getDirectBus(service_id1, service_id2);
        System.out.println("sssss");
        
        for(BusNumber bus : directBus){
            System.out.println(bus.getBusNumber());
        }

        return directBus;
    }



    public List<BusStation> getAroundBusStation(String name){
        System.out.print(name.split("\\(")[0]);
        FacilityService facilityService = new FacilityService();

        Facility facility = facilityService.getFacilities(name.split("\\(")[0]).get(0);
        double lat = facility.getLatitude(), lng = facility.getLongitude();
        List<BusStation> busStations = new ArrayList<>();
        busStations = busDao.getAroundBusStationByLatitudeAndLongitude(lat, lng);
        return busStations;
    }


    }





