package com.lqx.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.lqx.mapper.ContainerMapper;
import com.lqx.pojo.Container;
import com.lqx.pojo.ContainerExample;
import com.lqx.pojo.LandRepository;
import com.lqx.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author DUMBLEDOG
 * @date 2020/5/8 0:06
 */
@Service
public class ContainerServiceImpl implements ContainerService {
    @Autowired
    ContainerMapper containerMapper;
    @Override
    public void addContainer(Container container) {

    }

    @Override
    public void delContainerById() {

    }

    @Override
    public Container selectContainerById(int id) {
        return null;
    }

    @Override
    public String putToRepository(Container container, int repositoryId, int count) {
        JSONObject jsObj = new JSONObject();
        //获取 仓库信息
        LandRepository landRepository = containerMapper.selectByRepositoryKey(repositoryId);
        //判断是否类型匹配
        if(!container.getType().equals(landRepository.getContainerType())){
            jsObj.put("result", "failed");
            jsObj.put("msg", "货柜类型与仓库不匹配！");
            jsObj.put("resultPage",null);
            return jsObj.toJSONString();
        }
        int repoCapacity = landRepository.getSize();    //容量
        int repoCount = landRepository.getCount();      //库存 Stock
        int total = repoCount+count;                    //放进去后的总量
        int remain = 0;     //剩余量 ，如果一个仓库不够放，剩余量移交另一个仓库
        int canPut = 0;     //可放量
        System.out.println("{库存} " +repoCount);
        System.out.println("{总量} " +total);


        //判断是否放得完
        if(total<=repoCapacity){//可以完全存库
            landRepository.setCount(total);
            for (int i=0;i<count;i++){
                containerMapper.insertSelective(container);
            }
            //更新仓库存储信息
            landRepository.setCount(total);
            containerMapper.updateByRepositoryKey(landRepository);
            jsObj.put("result", "success");
            jsObj.put("msg", "码放完毕。");
            jsObj.put("resultPage","/Container/showContainerList");
            return jsObj.toJSONString();
        }else {//返回信息给前端，告知该仓库只能放下 "多少",不能放下的数量 remain
            canPut = repoCapacity-repoCount;
            remain = count - canPut;
            jsObj.put("result", "failed");
            jsObj.put("msg", "仓库空间不足，只能放 "+canPut+" 个货柜，剩下 "+remain+" 个货柜无法放置！请重新选择...");
            jsObj.put("resultPage",null);
        }
        return jsObj.toJSONString();
    }
    @Override
    public void putToShip(Container container, int shipNo) {

    }

    @Override
    public String showContaineList(Integer pageNum,Integer pageSize,Integer repositoryID) {
        JSONObject jsObj = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        List<Container> list = null;
        long count = 0;
        if(repositoryID==0){//如果仓库等于 0 则展示所有
            PageHelper.startPage(pageNum,pageSize);
            list = containerMapper.selectByExample(null);
            jsonArray.addAll(list);
            count = containerMapper.countByExample(null);
            //发给 LayUI: 用来做分页功能。
            //{1} 存入四项数据, 包装成: json
            jsObj.put( "code", "0" );  //数据(1):code
            jsObj.put( "msg", "测试" );   //数据(2):msg
            //数据(2): 总记录数
            jsObj.put( "count", count );
            //数据(3): Json数组
            jsObj.put("data", jsonArray );
            return jsObj.toJSONString();
        }
        PageHelper.startPage(pageNum,pageSize);
        list = containerMapper.selectByExample(null);
        jsonArray.addAll(list);
        count = containerMapper.countByExample(null);
        //发给 LayUI: 用来做分页功能。
        //{1} 存入四项数据, 包装成: json
        jsObj.put( "code", "0" );  //数据(1):code
        jsObj.put( "msg", "测试" );   //数据(2):msg
        //数据(2): 总记录数
        jsObj.put( "count", count );
        //数据(3): Json数组
        jsObj.put("data", jsonArray );
        return jsObj.toJSONString();
    }
}
