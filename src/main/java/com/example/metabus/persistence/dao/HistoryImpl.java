package com.example.metabus.persistence.dao;

import com.example.metabus.persistence.domain.BusStation;
import com.example.metabus.persistence.domain.Facility;
import com.example.metabus.persistence.domain.UserFacilityHistory;
import com.example.metabus.persistence.domain.UserRouteHistory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class HistoryImpl implements HistoryDao {
    MybatisUtil mybatisUtil;
    List<UserFacilityHistory> userFacilityHistories;

    @Override
    public List<Facility> getUserFacilityHistory(String userId) {

        List<Facility> facilities;

        SqlSession session = mybatisUtil.getInstance().getSqlSessionFactory().openSession();
        try {
             facilities = session.getMapper(HistoryDao.class).getUserFacilityHistory(userId);
            session.commit();
        } finally {
            session.close();
        }

        return facilities;
    }

    @Override
    public boolean insertUserFacilityHistory(int facility_id,int count, int userId){
        SqlSession session = mybatisUtil.getInstance().getSqlSessionFactory().openSession();
        boolean flag;
        try {
            flag = session.getMapper(HistoryDao.class).insertUserFacilityHistory(facility_id,count,userId);
            session.commit();
        } finally {
            session.close();
        }

        return flag;

    }

}
