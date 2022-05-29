package com.example.metabus.persistence.dao;

import com.example.metabus.persistence.domain.BusNumber;
import com.example.metabus.persistence.domain.BusStation;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BusDao {


    @ResultMap("DomainMapping.BusStationMapping")
    @Select("SELECT bus_station.*" +
            " FROM bus_station" +
            " WHERE #{latitude} >= #{latitude}-3 AND #{latitude} <= #{latitude} + 3  AND #{longitude} >= #{longitude} -3 AND #{longitude} <= #{longitude} + 3")
    public List<BusStation> getAroundBusStationByLatitudeAndLongitude(@Param("latitude")double latitude , @Param("longitude") double longitude);

    //    @ResultMap("JoinMapping.BusStationToBusNumber")
    @Select("SELECT bus_system.bus_number.bus_number" +
            " FROM layover as l INNER JOIN bus_station as bs1 on #{depStation} = l.station_id INNER JOIN bus_number as bn on l.bus_route_id = bn.private_id" +
            " INNER JOIN bus_station as bs2 on l.bus_route_id = #{arrStation} INNER JOIN bus_number as bn2 on l.bus_route_id = bn2.private_id;")
    public List<BusNumber> getLayOverBus(@Param("depStation") int depStation, @Param("arrStation")int arrStation);

}

