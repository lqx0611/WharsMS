package com.lqx.mapper;

import com.lqx.pojo.ContainerShip;
import com.lqx.pojo.ContainerShipExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContainerShipMapper {
    long countByExample(ContainerShipExample example);

    int deleteByExample(ContainerShipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ContainerShip record);

    int insertSelective(ContainerShip record);

    List<ContainerShip> selectByExample(ContainerShipExample example);

    ContainerShip selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ContainerShip record, @Param("example") ContainerShipExample example);

    int updateByExample(@Param("record") ContainerShip record, @Param("example") ContainerShipExample example);

    int updateByPrimaryKeySelective(ContainerShip record);

    int updateByPrimaryKey(ContainerShip record);
}