package com.example.metabus.service;

import com.example.metabus.persistence.dao.HistoryDao;
import com.example.metabus.persistence.dao.HistoryImpl;
import com.example.metabus.persistence.domain.Facility;
import com.example.metabus.persistence.domain.UserFacilityHistory;

import java.util.List;

public class HistoryService {

    HistoryDao historyDao;
    FacilityService facilityService;
    boolean flag =false;
    int facilityId;

    public HistoryService(){
        historyDao= new HistoryImpl();
    }

    public List<Facility> getUserHistoryOfFacility(String userId){
        List<Facility> facilities;
        facilities=historyDao.getUserFacilityHistory(userId);
        return facilities;
    }

    public boolean insertUserFacilityHistory( int loginId,String facilityName, int count)
    {

        facilityService = new FacilityService();
        List<Facility> facilities = facilityService.getFacilities(facilityName);

        for(Facility f : facilities){
            if(f.getName().equals(facilityName)){
                facilityId = f.getPrivateId();
                break;
            }
        }
        flag =historyDao.insertUserFacilityHistory(facilityId,count,loginId);
        return flag;

    }

}
