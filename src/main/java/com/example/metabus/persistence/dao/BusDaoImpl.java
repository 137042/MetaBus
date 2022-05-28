package com.example.metabus.persistence.dao;

import com.example.metabus.persistence.domain.BusNumber;
import com.example.metabus.persistence.domain.BusStation;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BusDaoImpl implements BusDao {
    MybatisUtil mybatisUtil;
    List<BusStation> busStations;
    List<BusNumber> busNumbers;
    @Override
    public List<BusStation> getAroundBusStationByLatitudeAndLongitude(double latitude, double longitude) {

        SqlSession session = MybatisUtil.getInstance().getSqlSessionFactory().openSession();
        try {
            busStations = session.getMapper(BusDao.class).getAroundBusStationByLatitudeAndLongitude(latitude, longitude);
            session.commit();
        } finally {
            session.close();
        }
        return busStations;
    }

    @Override
    public List<BusNumber> getLayOverBus(int depStation, int arrStation) {
        SqlSession session = mybatisUtil.getInstance().getSqlSessionFactory().openSession();
        try {
            busNumbers = session.getMapper(BusDao.class).getLayOverBus(depStation, arrStation);
            session.commit();
        } finally {
            session.close();
        }
        return busNumbers;    }
}
