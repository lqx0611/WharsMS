package com.lqx.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lqx.mapper.*;
import com.lqx.pojo.*;
import com.lqx.service.ContainerService;
import com.lqx.service.MatchingService;
import com.lqx.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DUMBLEDOG
 * @date 2020/5/10 23:34
 */
@Service
public class MatchingServiceImpl implements MatchingService {
    @Autowired
    ContainerMapper containerMapper;
    @Autowired
    ContainerShipMapper containerShipMapper;
    @Autowired
    ShipRepositoryMapper shipRepositoryMapper;
    @Autowired
    LandRepositoryMapper landRepositoryMapper;
    @Autowired
    ShipMapper shipMapper ;
    @Override
    public List<LandRepository> findAllLandRepository() {
        LandRepositoryExample lrExp = new LandRepositoryExample();
        LandRepositoryExample.Criteria cri = lrExp.createCriteria();
        cri.andIdIsNotNull();
        List<LandRepository> list =landRepositoryMapper.selectByExample(lrExp);
        return list;
    }

    @Override
    public String loadContainer(String shipNo, Integer repositoryId, Integer idMin, Integer idMax) {
        //{1}获取船体仓库
        ShipRepository shipRepository = shipRepositoryMapper.selectByShipNo(shipNo);

        //{2}获取陆地仓库
        LandRepository landRepository = landRepositoryMapper.selectByPrimaryKey(repositoryId);
        //{3}获取船只
        Ship ship = shipMapper.selectByShipNo(shipNo);
        //{ps}创建 json 对象 返回给ajax
        JSONObject jsObj = new JSONObject();
        jsObj.put("result","failed");
        jsObj.put("msg","装载失败！");
        jsObj.put("resultPage","/Container/showContainerList");
        //{ps}判断仓库是否有库存，没有则返回信息
        int lc = landRepository.getCount();
        int c = 0;
        for(int j = idMin;j<=idMax;j++){
            c++;
        }
        if( !(c<=lc) ){
            jsObj.put("result","failed");
            jsObj.put("msg","该仓库没有足够库存！");
            return jsObj.toJSONString();
        }
        //{ps}判断 筛选所选货柜的类型是否与船只匹配
        for(int k = idMin;k<=idMax;k++){
            //{4}获取陆地货柜记录
            Container container1 = containerMapper.selectByPrimaryKey(k);
            if(!container1.getType().substring(0,2).equals(ship.getType().substring(0,2))){
                //return "所选货柜中，含有与船只类型不匹配类型。";
                jsObj.put("result","failed");
                jsObj.put("msg","所选货柜中，含有与船只类型不匹配类型。");
                return jsObj.toJSONString();
            }

        }


        int count = 0; //船上货柜数量
        for(int i = idMin;i<=idMax;i++){
            //{4}获取陆地货柜记录
            Container container2 = containerMapper.selectByPrimaryKey(i);
            //{5}生成船体货柜记录
            ContainerShip containerShip = new ContainerShip(container2);
            containerShip.setShipNo(shipNo);
            //{6}出仓  删除陆地货柜记录  表1
            containerMapper.deleteByPrimaryKey(i);
            //{7}装船  添加船上货柜记录  表2
            containerShipMapper.insert(containerShip);
            count++; //装船货柜数量
        }
        //{8}更改船只货柜数量
        int shipCount = count+ship.getCount();
        ship.setCount(shipCount);
        ShipExample sExp = new ShipExample();
        ShipExample.Criteria cri = sExp.createCriteria();
        cri.andNoEqualTo(shipNo);
        shipMapper.updateByExampleSelective(ship,sExp);  //表3
        //{9} 更改陆地仓库的库存
        int landCount = landRepository.getCount()-count;
        landRepository.setCount(landCount);
        LandRepositoryExample lrExp = new LandRepositoryExample();
        LandRepositoryExample.Criteria cri2 = lrExp.createCriteria();
        cri2.andIdEqualTo(repositoryId);
        landRepositoryMapper.updateByExampleSelective(landRepository,lrExp);//表4
        //{10} 更改船体仓库的库存
        int shipReCount = shipRepository.getCount() + count;
        shipRepository.setCount(shipReCount);
        ShipRepositoryExample srExp = new ShipRepositoryExample();
        ShipRepositoryExample.Criteria cri3 = srExp.createCriteria();
        cri3.andShipNoEqualTo(shipNo);
        shipRepositoryMapper.updateByExampleSelective(shipRepository,srExp);//表5

        //return "装船完毕！";
        jsObj.put("result","success");
        jsObj.put("msg","装船完毕！！");
        jsObj.put("resultPage","/Container/showContainerList");
        return jsObj.toJSONString();
    }

    @Override
    public String dischargeContainer(String shipNo, Integer repositoryId, Integer idMin, Integer idMax) {
        //{1}获取船体仓库
        ShipRepository shipRepository = shipRepositoryMapper.selectByShipNo(shipNo);
        //{2}获取陆地仓库
        LandRepository landRepository = landRepositoryMapper.selectByPrimaryKey(repositoryId);
        //{3}获取船只
        Ship ship = shipMapper.selectByShipNo(shipNo);
        //{ps}创建 json 对象 返回给ajax
        JSONObject jsObj = new JSONObject();
        jsObj.put("result","failed");
        jsObj.put("msg","卸载失败！");
        jsObj.put("resultPage","/Container/showContainerList");
        //{ps}判断仓库是否有库存，没有则返回信息
        int lc = shipRepository.getCount();
        int c = 0;
        for(int j = idMin;j<=idMax;j++){
            c++;
        }
        if( !(c<=lc) ){
            jsObj.put("result","failed");
            jsObj.put("msg","所选货柜超出库存！");
            return jsObj.toJSONString();
        }
        //{ps}判断 筛选卸载货柜的类型是否与仓库匹配
        if(!shipRepository.getContainerType().equals(landRepository.getContainerType())){
            //return "所选货柜中，含有与船只类型不匹配类型。";
            jsObj.put("result","failed");
            jsObj.put("msg","所选货柜中，含有与仓库类型不匹配类型。");
            return jsObj.toJSONString();
        }
        int count = 0; //卸载货柜数量
        for(int i = idMin;i<=idMax;i++){
            //{4}获取船体货柜记录*
            ContainerShip containerShip = containerShipMapper.selectByPrimaryKey(i);
            //{5}生成陆地货柜记录*
            Container container = new Container(containerShip);
            container.setRepository(repositoryId);
            //{6}卸船  删除陆地货柜记录  表1 *
            containerShipMapper.deleteByPrimaryKey(i);
            //{7}入仓  添加船上货柜记录  表2 *
            containerMapper.insert(container);
            count++; //装船货柜数量
        }
        //{8}更改船只货柜数量
        int shipCount = ship.getCount()-count;
        ship.setCount(shipCount);
        ShipExample sExp = new ShipExample();
        ShipExample.Criteria cri = sExp.createCriteria();
        cri.andNoEqualTo(shipNo);
        shipMapper.updateByExampleSelective(ship,sExp);  //表3
        //{9} 更改陆地仓库的库存
        int landCount = landRepository.getCount()+count;
        landRepository.setCount(landCount);
        LandRepositoryExample lrExp = new LandRepositoryExample();
        LandRepositoryExample.Criteria cri2 = lrExp.createCriteria();
        cri2.andIdEqualTo(repositoryId);
        landRepositoryMapper.updateByExampleSelective(landRepository,lrExp);//表4
        //{10} 更改船体仓库的库存
        int shipReCount = shipRepository.getCount()- count;
        shipRepository.setCount(shipReCount);
        ShipRepositoryExample srExp = new ShipRepositoryExample();
        ShipRepositoryExample.Criteria cri3 = srExp.createCriteria();
        cri3.andShipNoEqualTo(shipNo);
        shipRepositoryMapper.updateByExampleSelective(shipRepository,srExp);//表5

        //return "卸船完毕！";
        jsObj.put("result","success");
        jsObj.put("msg","卸船完毕！！");
        jsObj.put("resultPage","/Container/showContainerList");
        return jsObj.toJSONString();
    }
}
