package com.example.metabus.service;

import com.example.metabus.persistence.dao.*;
import com.example.metabus.persistence.domain.Facility;
import com.example.metabus.persistence.domain.FacilityGroup;

import java.util.ArrayList;
import java.util.List;

public class FacilityService {

    private FacilityDao findFacilityFromLocationDao;

    public FacilityService() {
        findFacilityFromLocationDao = new FacilityDaoImpl();
    }

    public List<Facility> getFacility(String facilityName){
        List<Facility> facilities = new ArrayList<>();
        facilities = findFacilityFromLocationDao.getNameContainsFacility(facilityName);
        return facilities;
    }

    public List<FacilityGroup> getGroupOfFacility(String facilityName){
        List<FacilityGroup> facilityGroups = new ArrayList<>();
        facilityGroups = findFacilityFromLocationDao.getFacilityGroups(facilityName);
        return facilityGroups;
    }

}


