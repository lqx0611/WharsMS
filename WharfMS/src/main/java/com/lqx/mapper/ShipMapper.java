package com.lqx.mapper;

import com.lqx.pojo.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ShipMapper {
    long countByExample(ShipExample example);

    int deleteByExample(ShipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ship record);

    int insertSelective(Ship record);

    List<Ship> selectByExample(ShipExample example);

    Ship selectByPrimaryKey(Integer id);
    Ship selectByShipNo(String shipNo);

    int updateByExampleSelective(@Param("record") Ship record, @Param("example") ShipExample example);

    int updateByExample(@Param("record") Ship record, @Param("example") ShipExample example);

    int updateByPrimaryKeySelective(Ship record);

    int updateByPrimaryKey(Ship record);

    List<ShipInfo> selectShipInfo();

    List<ShipRoute> selectShipRoute();

    Berth selectBerth(String berthNo);

    int setBerthStatus(Berth berth);

    int setBerthTime(BerthTime berthTime);

    int insertRoute(Route record);

    Route findRouteIsHas(String shipNo);
    int updateRoute(Route record);

    void deleteRouteByShipNo(String shipNo);
}