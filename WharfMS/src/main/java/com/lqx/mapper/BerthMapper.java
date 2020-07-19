package com.lqx.mapper;

import com.lqx.pojo.Berth;
import com.lqx.pojo.BerthExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BerthMapper {
    long countByExample(BerthExample example);

    int deleteByExample(BerthExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Berth record);

    int insertSelective(Berth record);

    List<Berth> selectByExample(BerthExample example);

    Berth selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Berth record, @Param("example") BerthExample example);

    int updateByExample(@Param("record") Berth record, @Param("example") BerthExample example);

    int updateByPrimaryKeySelective(Berth record);

    int updateByPrimaryKey(Berth record);

    Berth selectByBerthNo(String berthNo);
}