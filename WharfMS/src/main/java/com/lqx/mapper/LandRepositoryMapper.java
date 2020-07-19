package com.lqx.mapper;

import com.lqx.pojo.LandRepository;
import com.lqx.pojo.LandRepositoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LandRepositoryMapper {
    long countByExample(LandRepositoryExample example);

    int deleteByExample(LandRepositoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LandRepository record);

    int insertSelective(LandRepository record);

    List<LandRepository> selectByExample(LandRepositoryExample example);

    LandRepository selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LandRepository record, @Param("example") LandRepositoryExample example);

    int updateByExample(@Param("record") LandRepository record, @Param("example") LandRepositoryExample example);

    int updateByPrimaryKeySelective(LandRepository record);

    int updateByPrimaryKey(LandRepository record);
}