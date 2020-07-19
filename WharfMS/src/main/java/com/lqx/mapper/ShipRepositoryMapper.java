package com.lqx.mapper;

import com.lqx.pojo.ShipRepository;
import com.lqx.pojo.ShipRepositoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShipRepositoryMapper {
    long countByExample(ShipRepositoryExample example);

    int deleteByExample(ShipRepositoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShipRepository record);

    int insertSelective(ShipRepository record);

    List<ShipRepository> selectByExample(ShipRepositoryExample example);

    ShipRepository selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShipRepository record, @Param("example") ShipRepositoryExample example);

    int updateByExample(@Param("record") ShipRepository record, @Param("example") ShipRepositoryExample example);

    int updateByPrimaryKeySelective(ShipRepository record);

    int updateByPrimaryKey(ShipRepository record);

    ShipRepository selectByShipNo(String shipNo);
}