package com.lqx.service;

import com.lqx.pojo.*;

import java.util.List;

/**
 * @author DUMBLEDOG
 * @date 2020/5/3 23:28
 */
public interface ShipService {
//    {1}增   ===> 记录新泊船只
    String addShip(Ship ship);
//    {2}删	  ===> 改泊位状态 1-->0
    void updateBerth(Berth berth);
//    {3}改   ===> 改变停泊时间
    void updateBerthTime();
//    {4}查   ===> 查询船只信息 包括船只本身信息、停留信息。
    Ship selectShipByNo(String shipNo);
//    {5}查  ===> 查询全部船只信息 json串
    String selectAllShip(Integer pageNum,Integer pageSize);

    String selectShiInfo();

    BerthTime setBerthTime(BerthTime berthTime);

    Berth selectBerth(String berthNo);
    String selectShipRoute();
    List<Ship> findAllShip();
    void saveShipRoute(Route route);

    void setBerthStatus(Berth berth);

    String shipOutNow(String shipNo);

    List<Ship> findAllShipBerthed();
}
