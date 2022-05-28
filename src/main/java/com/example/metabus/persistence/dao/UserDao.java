package com.example.metabus.persistence.dao;

import com.example.metabus.persistence.domain.User;
import com.example.metabus.persistence.domain.UserRouteHistory;
import org.apache.ibatis.annotations.*;

public interface UserDao {

    //    유저 입력
    @Insert("INSERT INTO USER(name,login_id,login_pw) VALUES (#{name}, #{login_id}, #{login_pw}")
    @ResultMap("DomainMapping.UserResultMapping")
    public boolean insertUser(User user);


    @Select("SELECT login_id FROM USER WHERE login_id=#{login_id}")
    @ResultMap("DomainMapping.UserResultMapping")
    public User checkIdIsDuplicated(@Param("login_id") String id);
    //유저 id 중복 체크 쿼리

    //유저 검증
    @Select("SELECT login_id, login_pw FROM USER WHERE login_id=#{login_id} AND login_pw =#{login_pw}")
    @ResultMap("DomainMapping.UserResultMapping")
    public User checkValidation(@Param("login_id")String id, @Param("login_pw")String pw);


    //비밀번호 찾기
    @Select("SELECT login_pw FROM USER where login_id = #{login_id}")
    @ResultMap("DomainMapping.UserResultMapping")
    public User findPassword(@Param("login_id")String id);



    //유저 히스토리 반환(Route)
    @Select("SELECT start_station_id, arrival_station_id FROM USER_ROUTE_HISTORY INNER JOIN USER ON USER_ROUTE_HISTORY.#{user_id} = USER.#{user_id}")
    @ResultMap("DomainMapping.UserResultMapping")
    public UserRouteHistory getUserRouteHistory(@Param("user_id")String id);



}
