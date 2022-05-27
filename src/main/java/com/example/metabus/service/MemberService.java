package com.example.metabus.service;

import com.example.metabus.persistence.dao.UserDao;
import com.example.metabus.persistence.dao.UserDaoImpl;
import com.example.metabus.persistence.domain.User;
import com.example.metabus.persistence.domain.UserRouteHistory;

import java.util.ArrayList;
import java.util.List;

public class MemberService {

   private UserDao userDao;

    public MemberService() {
        userDao= new UserDaoImpl();
    }

    public Boolean UserValidation(String id, String pw){
        User user;
        user = userDao.checkValidation(id,pw);
        if(user.getLoginId().equals(id) && user.getLoginPassword().equals(pw))
        {
            return true;
        }
            return false;
    }

    public String findPassWord(String id){
        User user;
        user = userDao.findPassword(id);
        if(user.getLoginId().equals(id))
        {
            return user.getLoginPassword();
        }
        return null;
    }

    public boolean signUp(String name, String id, String pw)
    {
        boolean flag;
        User user=new User(name,id,pw);
         flag = userDao.insertUser(user);
         return flag;
    }

    public List<Integer> getUserRouteHistory(String id){
        List<Integer> routeInfo = new ArrayList<>();
        UserRouteHistory userRouteHistory;
        userRouteHistory = userDao.getUserRouteHistory(id);
        int startStation = userRouteHistory.getStartStationId();
        int arrivalStation =userRouteHistory.getArrivalStationId();
        routeInfo.add(startStation,0);
        routeInfo.add(arrivalStation, 1);
        return routeInfo;
    }

}
