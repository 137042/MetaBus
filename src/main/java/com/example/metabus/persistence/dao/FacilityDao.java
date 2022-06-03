package com.example.metabus.persistence.dao;

import com.example.metabus.persistence.domain.Facility;
import com.example.metabus.persistence.domain.FacilityGroup;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface FacilityDao {

    @ResultMap("DomainMapping.FacilityMapping")
    @Select("SELECT * FROM FACILITY WHERE NAME LIKE  CONCAT('%',#{name},'%')")
    public List<Facility> getNameContainsFacility(@Param("name")String facilityName);


    @Select("select category_name" +
            " FROM group_of_facilities as gof" +
            " INNER JOIN facility f on gof.facility_id=f.private_id" +
            " INNER JOIN facility_groups AS fg on gof.facility_group_id=fg.private_id" +
            " where f.name LIKE CONCAT('%',#{name},'%')")
    @ResultMap("DomainMapping.FacilityGroupMapping")
    @ResultType(com.example.metabus.persistence.domain.FacilityGroup.class)

    public List<FacilityGroup> getFacilityGroups(@Param("name") String facilityName);



}
