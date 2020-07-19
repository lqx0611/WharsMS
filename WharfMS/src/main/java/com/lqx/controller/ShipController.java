package com.lqx.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.lqx.pojo.*;
import com.lqx.service.ShipService;
import com.lqx.service.UserService;
import com.sun.jndi.ldap.Ber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author DUMBLEDOG
 * @date 2020/5/3 23:27
 */
@Controller
@RequestMapping("/Ship")
public class ShipController {
    @Autowired
    ShipService shipService;


    //船只出行,查询所有船只的信息，发给前端
    @RequestMapping("/showShipPullOut")
    public String showShipPullOut(HttpServletRequest req){
        //查询所有船只信息，发给前端，让前端做选择
      List<Ship> listShip = shipService.findAllShipBerthed();
        req.setAttribute("listShip",listShip);
        return "ship/shipPullOut";
    }
    //船只出行提交,
    //在这里更改数据库相关信息
    @RequestMapping(value = "/shipPullOut",produces="text/html;charset=UTF-8")
    //@ResponseBody //test
    public String shipPullOut(Route route){
        System.out.println("{获取出行路线} " + route);
        shipService.saveShipRoute(route);
        return "ship/shipRoute";
    }

    //查看船只信息
    @RequestMapping("/showShipList")
    public String showShipList(){
        return "ship/shipList";
    }
    @RequestMapping(value="/shipList",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String shipList(@RequestParam("page") Integer pageNum, @RequestParam("limit") Integer pageSize){
        String json = shipService.selectAllShip(pageNum,pageSize);
        System.out.println("+===============================================+");
        System.out.println("json:"+json);
        System.out.println("+===============================================+");
        return json;
    }
    //船只停泊
    @RequestMapping("/showAddShip")
    public String showAddShip(){
        return "ship/addShip";
    }
    @RequestMapping(value="/addShip",produces="text/html;charset=UTF-8")
    public String addShip(ShipInfo shipInfo){
        String ret = "failed";
        System.out.println("{shipInfo} Ctr  "+shipInfo);
        Berth berth = shipService.selectBerth(shipInfo.getBerthNo());
        if (berth.getStatus().equals("0")){
            Ship ship = new Ship(shipInfo);
            BerthTime berthTime = new BerthTime(shipInfo);
            shipService.setBerthTime(berthTime);
            ship.setTimeId(berthTime.getId());
            ret = shipService.addShip(ship);
            System.out.println("addShip ret :"+ret);
            shipService.setBerthStatus(berth);
            return "ship/shipList";
        }
        return "ship/berthFailed";
    }

    //查看船只路线
    @RequestMapping("/showShipRoute")
    public String showShipRoute(){
        return "ship/shipRoute";
    }
    @RequestMapping(value="/shipRoute",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String shipRoute(){
        String json = shipService.selectShipRoute();
        return json;
    }


    @RequestMapping("/shipOutNow")
    @ResponseBody
    public String shipOutNow(HttpServletRequest request){
        JSONObject json = new JSONObject();
        String no = request.getParameter("no");
        String ret = shipService.shipOutNow(no);
        json.put("result",ret);
        return  json.toJSONString();
    }

}
