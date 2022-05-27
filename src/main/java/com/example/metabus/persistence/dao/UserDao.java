package com.example.metabus.persistence.dao;

import com.example.metabus.persistence.domain.User;
import com.example.metabus.persistence.domain.UserRouteHistory;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserDao {

    //유저 입력
    @Insert("INSERT INTO USER(name,login_id,login_pw) VALUES (#{name}, #{login_id}, #{login_pw}")
    public boolean insertUser(User user);

    //유저 id 중복 체크 쿼리
    @Select("SELECT login_id FROM USER WHERE login_id=#{login_id}")
    @Result(property = "loginId", column = "login_id")
    public User checkIdIsDuplicated(int id);

    //유저 검증
    @Select("SELECT login_id, login_pw FROM USER WHERE login_id=#{login_id} AND login_pw =#{login_pw}")
    @Result(property = "loginId", column = "login_id")
    @Result(property = "loginPassword", column = "login_pw")
    public User checkValidation(String id, String pw);

    //비밀번호 찾기
    @Select("SELECT login_pw FROM USER where login_id =#{login_id}")

    public User findPassword(String id);

    //유저 히스토리 반환(Route)
    @Select("SELECT start_station_id, arrival_station_id FROM USER_ROUTE_HISTORY INNER JOIN USER ON USER_ROUTE_HISTORY.#{user_id} = USER.#{user_id}")
    @Result(property = "startStationId", column = "start_station_id")
    @Result(property = "arrivalStationId", column = "arrival_station_id")
    public UserRouteHistory getUserRouteHistory(String userId);



}
