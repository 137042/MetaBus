package com.example.metabus.persistence.dao;

import com.example.metabus.persistence.domain.BusNumber;
import com.example.metabus.persistence.domain.BusStation;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class BusDaoImpl implements BusDao {
    MybatisUtil mybatisUtil;
    List<BusStation> busStations;
    List<BusNumber> busNumbers;
    @Override
    public List<BusStation> getAroundBusStationByLatitudeAndLongitude(double latitude, double longitude) {

        SqlSession session = mybatisUtil.getInstance().getSqlSessionFactory().openSession();
        try {
            busStations = session.getMapper(BusDao.class).getAroundBusStationByLatitudeAndLongitude(latitude, longitude);
            System.out.println(busStations);
            session.commit();
        } finally {
            session.close();
        }
        return busStations;
    }

    @Override
    public List<BusNumber> getDirectBus(int id1, int id2) {
        SqlSession session = mybatisUtil.getInstance().getSqlSessionFactory().openSession();
        try {
            System.out.println(id1 + " " + id2);
            busNumbers = session.getMapper(BusDao.class).getDirectBus(id1, id2);
            session.commit();
        } finally {
            session.close();
        }
        return busNumbers;
    }

    @Override
    public List<BusNumber> getLayOverBus(String depStation, String arrStation) {
        SqlSession session = mybatisUtil.getInstance().getSqlSessionFactory().openSession();
        try {
            busNumbers = session.getMapper(BusDao.class).getLayOverBus(depStation, arrStation);
            session.commit();
        } finally {
            session.close();
        }
        return busNumbers;    }
}
