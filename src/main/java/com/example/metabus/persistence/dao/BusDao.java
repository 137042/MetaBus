package com.example.metabus.persistence.dao;

import com.example.metabus.persistence.domain.BusNumber;
import com.example.metabus.persistence.domain.BusStation;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface BusDao {


    @ResultMap("DomainMapping.BusStationMapping")
    @Select("SELECT *" +
            " FROM bus_station" +
            " WHERE latitude >= #{latitude}- 0.003 AND latitude <= #{latitude} + 0.003  AND longitude >= #{longitude} - 0.003 AND longitude <= #{longitude} + 0.003")
    public List<BusStation> getAroundBusStationByLatitudeAndLongitude(@Param("latitude")double latitude , @Param("longitude") double longitude);

    @ResultMap("DomainMapping.BusNumberMapping")
    @Select("SELECT bn.bus_number" +
            "FROM layover as l" +
            "INNER JOIN bus_station bs1 on l.station_id = #{service_id1} AND bs1.service_id=#{service_id1}" +
            "INNER JOIN bus_station bs2 on l.station_id = #{service_id2} AND bs2.service_id=#{service_id2}" +
            "INNER JOIN bus_number bn on l.bus_route_id = bn.private_id")
    public List<BusNumber> getDirectBus(@Param("service_id1") int service_id1, @Param("service_id2") int service_id2);




    @ResultMap("DomainMapping.BusNumberMapping")
    @Select("SELECT DISTINCT bn1.*" +
            " FROM layover as l " +
            " INNER JOIN bus_number bn1 on bn1.start_station=#{depStation}" +
            " INNER JOIN bus_number bn2 on bn2.end_station=#{arrStation}" +
            " where bn1.end_station = bn2.start_station"+
            " UNION"+
            " SELECT DISTINCT bn2.*" +
            " FROM layover as l " +
            " INNER JOIN bus_number bn1 on bn1.start_station=#{depStation}" +
            " INNER JOIN bus_number bn2 on bn2.end_station=#{arrStation}" +
            " where bn1.end_station = bn2.start_station"
    )
    public List<BusNumber> getLayOverBus(@Param("depStation") String depStation, @Param("arrStation") String arrStation);


}
