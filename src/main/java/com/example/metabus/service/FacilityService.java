package com.example.metabus.service;

import com.example.metabus.persistence.dao.*;
import com.example.metabus.persistence.domain.Facility;
import com.example.metabus.persistence.domain.FacilityGroup;

import java.util.ArrayList;
import java.util.List;

public class FacilityService {

    private FacilityDao facilityDao;

    public FacilityService() {
        facilityDao = new FacilityDaoImpl();
    }

    public List<Facility> getFacilities(String facilityName){
        List<Facility> facilities = new ArrayList<>();
        facilities = facilityDao.getNameContainsFacility(facilityName);
        return facilities;
    }

    public List<FacilityGroup> getFacilityGroupCategoryName(String facilityName){
        List<FacilityGroup> facilityGroups = new ArrayList<>();
        facilityGroups = facilityDao.getFacilityGroups(facilityName);
        return facilityGroups;
    }

    }


