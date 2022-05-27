package com.example.metabus.persistence.dao;

import com.example.metabus.persistence.domain.Facility;
import com.example.metabus.persistence.domain.FacilityGroup;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class FindFacilityFromLocationImpl implements FindFacilityFromLocation {

    MybatisUtil mybatisUtil;
    List<Facility> facilities;
    List<FacilityGroup> facilityGroupList;

    @Override
    public List<Facility> getNameContainsFacility(String facilityName) {
        SqlSession session = mybatisUtil.getInstance().openSession();
        try{
            facilities = session.getMapper(FindFacilityFromLocation.class).getNameContainsFacility(facilityName);
            session.commit();
        }
        finally {
            session.close();
        }
        return facilities;

    }




    @Override
    public List<FacilityGroup> getFacilityGroups(String facilityName) {
        SqlSession session = mybatisUtil.getInstance().openSession();
        try {
            facilityGroupList = session.getMapper(FindFacilityFromLocation.class).getFacilityGroups(facilityName);
            session.commit();
        } finally {
            session.close();
        }
        return facilityGroupList;
    }
}
