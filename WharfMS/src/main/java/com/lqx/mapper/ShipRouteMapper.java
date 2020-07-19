package com.lqx.mapper;

import com.lqx.pojo.ShipRoute;
import com.lqx.pojo.ShipRouteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShipRouteMapper {
    long countByExample(ShipRouteExample example);

    int deleteByExample(ShipRouteExample example);

    int insert(ShipRoute record);

    int insertSelective(ShipRoute record);

    List<ShipRoute> selectByExample(ShipRouteExample example);

    int updateByExampleSelective(@Param("record") ShipRoute record, @Param("example") ShipRouteExample example);

    int updateByExample(@Param("record") ShipRoute record, @Param("example") ShipRouteExample example);
}