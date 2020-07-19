package com.lqx.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.github.pagehelper.PageHelper;
import com.lqx.mapper.*;
import com.lqx.pojo.*;
import com.lqx.pojo.ShipExample.Criteria;

import com.lqx.service.ShipService;
import com.sun.jndi.ldap.Ber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DUMBLEDOG
 * @date 2020/5/3 23:28
 */
@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    ShipMapper shipMapper;
    @Autowired
    ShipInfoMapper shipInfoMapper;
    @Autowired
    ShipRouteMapper shipRouteMapper;
    @Autowired
    ShipRepositoryMapper shipRepositoryMapper;
    @Autowired
    BerthMapper berthMapper;

    @Override
    public String addShip(Ship ship) {
        String ret = "failed";
        try {
            shipMapper.insert(ship);
            ShipRepository shipRepository = new ShipRepository(ship);
            shipRepositoryMapper.insert(shipRepository);
            ret = "success";
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public void updateBerth(Berth berth) {
        shipMapper.setBerthStatus(berth);
    }
    @Override
    public void updateBerthTime() {

    }
    @Override
    public Ship selectShipByNo(String shipNo) {
        return null;
    }

    @Override
    public String selectAllShip(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ShipInfo> listShipInfo = shipInfoMapper.selectByExample(null);
        JSONObject jsObj = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        jsonArray.addAll(listShipInfo);
        int count  = shipInfoMapper.count();//总记录数
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

    @Override
    public String selectShiInfo() {
        List<ShipInfo> listShipInfo = shipMapper.selectShipInfo();
        JSONObject jsObj = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        int count = 0; //总记录数
        for (ShipInfo shipInfo : listShipInfo) {
            jsonArray.add(shipInfo);
            System.out.println( shipInfo );
            count++;
        }
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

    @Override
    public BerthTime setBerthTime(BerthTime berthTime) {
        shipMapper.setBerthTime(berthTime);
        return berthTime;
    }

    @Override
    public Berth selectBerth(String berthNo) {
        Berth berth = shipMapper.selectBerth(berthNo);
        return berth;
    }

    @Override
    public String selectShipRoute() {
//        List<ShipRoute> listShipRpute = shipMapper.selectShipRoute();

        ShipRouteExample sExp = new ShipRouteExample();
        ShipRouteExample.Criteria cri = sExp.createCriteria();
        cri.andIdIsNotNull();
        //List<Ship> listShip = shipMapper.selectByExample(sExp);
        List<ShipRoute> listShipRoute = shipRouteMapper.selectByExample(sExp);

        JSONObject jsObj = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        int count = 0; //总记录数
        for (ShipRoute shipRoute : listShipRoute) {
            jsonArray.add(shipRoute);
            System.out.println( shipRoute );
            count++;
        }
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

    @Override
    public List<Ship> findAllShip() {
        ShipExample sExp = new ShipExample();
        Criteria cri = sExp.createCriteria();
        cri.andIdIsNotNull();
        List<Ship> listShip = shipMapper.selectByExample(sExp);
        return listShip;
    }

    @Override
    public void saveShipRoute(Route route) {
        //查询船号，看看是否已经有了路线，有就覆盖，没有就插入一个
        String shipNo = route.getShipNo();
        Route queryRoute = shipMapper.findRouteIsHas(shipNo);
        if (queryRoute!=null){
            shipMapper.updateRoute(route);
            return;
        }
        shipMapper.insertRoute(route);
        //return null;
    }

    @Override
    public void setBerthStatus(Berth record) {
        if(record.getStatus().equals("0")){
            record.setStatus("1");
        }else {
            record.setStatus("0");
        }
        berthMapper.updateByPrimaryKey(record);
    }

    @Override
    public String shipOutNow(String shipNo) {
        //查询船只
        Ship ship = shipMapper.selectByShipNo(shipNo);
        //更改船只停泊状态
        ship.setBerthNo(null);
        ship.setStatus(0);
        //清除停泊时间
        ship.setTimeId(null);
        shipMapper.updateByPrimaryKey(ship);
        //清除航线
        shipMapper.deleteRouteByShipNo(ship.getNo());
        //更改泊位状态
        Berth berth = berthMapper.selectByBerthNo(ship.getBerthNo());
        setBerthStatus(berth);
        return "success";
    }

    @Override
    public List<Ship> findAllShipBerthed() {
        ShipExample sExp = new ShipExample();
        Criteria cri = sExp.createCriteria();
        cri.andStatusEqualTo(1);
        List<Ship> listShip = shipMapper.selectByExample(sExp);
        return listShip;
    }
}
