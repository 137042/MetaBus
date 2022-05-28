package com.example.metabus.persistence.dao;

import com.example.metabus.persistence.domain.User;
import com.example.metabus.persistence.domain.UserRouteHistory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserDaoImpl implements UserDao  {

    MybatisUtil mybatisUtil;
    @Override
    public boolean insertUser(User user) {
        SqlSession session = mybatisUtil.getInstance().getSqlSessionFactory().openSession();
        boolean flag;
        try {
            flag=  session.getMapper(UserDao.class).insertUser(user);
            session.commit();
        } finally {
            session.close();
        }
        return flag;

    }

    @Override
    public User checkIdIsDuplicated(String id) {
        SqlSession session = mybatisUtil.getInstance().getSqlSessionFactory().openSession();
        User user;
        try {
            user= session.getMapper(UserDao.class).checkIdIsDuplicated(id);
            session.commit();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public User checkValidation(String id, String pw) {

        SqlSession session = mybatisUtil.getInstance().getSqlSessionFactory().openSession();
        User user;
        try {
            user = session.getMapper(UserDao.class).checkValidation(id,pw);
            session.commit();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public User findPassword(String id) {

        SqlSession session = mybatisUtil.getInstance().getSqlSessionFactory().openSession();
        User user;
        try {
            user = session.getMapper(UserDao.class).findPassword(id);
            session.commit();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public UserRouteHistory getUserRouteHistory(String userId) {
        SqlSession session = mybatisUtil.getInstance().getSqlSessionFactory().openSession();
        UserRouteHistory userRouteHistory;
        try {
            userRouteHistory = session.getMapper(UserDao.class).getUserRouteHistory(userId);
            session.commit();
        } finally {
            session.close();
        }
        return userRouteHistory;
    }


}
