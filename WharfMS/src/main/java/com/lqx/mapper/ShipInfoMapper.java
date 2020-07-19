package com.lqx.mapper;

import com.lqx.pojo.ShipInfo;
import com.lqx.pojo.ShipInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShipInfoMapper {
    long countByExample(ShipInfoExample example);

    int deleteByExample(ShipInfoExample example);

    int insert(ShipInfo record);

    int insertSelective(ShipInfo record);

    List<ShipInfo> selectByExample(ShipInfoExample example);

    int updateByExampleSelective(@Param("record") ShipInfo record, @Param("example") ShipInfoExample example);

    int updateByExample(@Param("record") ShipInfo record, @Param("example") ShipInfoExample example);

    int count();
}