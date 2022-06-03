package com.example.metabus.persistence.dao;

import com.example.metabus.persistence.domain.Facility;
import com.example.metabus.persistence.domain.User;
import com.example.metabus.persistence.domain.UserFacilityHistory;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface HistoryDao {

    @Select( "select f.*" +
            " from user_facility_history" +
            " INNER JOIN user u on user_facility_history.user_id = u.login_id LIKE #{login_id}"+
            " INNER JOIN facility f on user_facility_history.facility_id = f.private_id")
    @ResultType(com.example.metabus.persistence.domain.Facility.class)
    public List<Facility> getUserFacilityHistory(@Param("login_id") String userId);

    @Insert("INSERT INTO user_facility_history(facility_id,count,user_id)  VALUES (#{facility_id}, #{count}, #{user_id})")
    public boolean insertUserFacilityHistory(@Param("facility_id") int facility_id,@Param("count") int count, @Param("user_id") int userId );







}
