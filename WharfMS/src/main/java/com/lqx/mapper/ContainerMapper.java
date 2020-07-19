package com.lqx.mapper;

import com.lqx.pojo.Container;
import com.lqx.pojo.ContainerExample;
import java.util.List;

import com.lqx.pojo.LandRepository;
import org.apache.ibatis.annotations.Param;

public interface ContainerMapper {
    long countByExample(ContainerExample example);

    int deleteByExample(ContainerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Container record);

    int insertSelective(Container record);

    List<Container> selectByExample(ContainerExample example);

    Container selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Container record, @Param("example") ContainerExample example);

    int updateByExample(@Param("record") Container record, @Param("example") ContainerExample example);

    int updateByPrimaryKeySelective(Container record);

    int updateByPrimaryKey(Container record);
//分割线-------------------------
    int getRepositoryCount(Integer repositoryId);

    LandRepository selectByRepositoryKey(Integer id);

    int updateByRepositoryKey(LandRepository record);
}