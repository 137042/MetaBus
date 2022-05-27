package com.example.metabus.persistence.dao;

import com.example.metabus.persistence.domain.Facility;
import com.example.metabus.persistence.domain.FacilityGroup;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FindFacilityFromLocation {

    @Select("SELECT * FROM FACILITY WHERE NAME LIKE '{#name}%'")
    public List<Facility> getNameContainsFacility(String facilityName);

    @ResultMap("facilityMapToFacilityGroup")
    @Select("select fg.category_name FROM group_of_facilities as gof INNER JOIN facility f on gof.facility_id=f.private_id  INNER JOIN facility_groups AS fg on gof.facility_group_id=fg.private_id")
    public List<FacilityGroup> getFacilityGroups(String facilityName);

    /* getFacilityGroups SQL
    select fg.category_name

    FROM group_of_facilities as gof INNER JOIN facility f on gof.facility_id = f.private_id
    INNER JOIN facility_groups AS fg
    on gof.facility_group_id = fg.private_id
    */
}
