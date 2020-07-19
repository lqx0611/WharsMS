package com.lqx.controller;

import com.alibaba.fastjson.JSONObject;
import com.lqx.mapper.ContainerMapper;
import com.lqx.mapper.ShipMapper;
import com.lqx.pojo.LandRepository;
import com.lqx.pojo.Ship;
import com.lqx.service.ContainerService;
import com.lqx.service.MatchingService;
import com.lqx.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * @author DUMBLEDOG
 * @date 2020/5/10 23:20
 */
@Controller
@RequestMapping("/Matching")
public class MatchingController {
    @Autowired
    ShipService shipService;
    @Autowired
    ContainerService containerService;
    @Autowired
    MatchingService matchingService;

    //去到卸载货柜页面
    @RequestMapping(value="/showDischarge",produces="text/html;charset=UTF-8")
    public String showDischarge(HttpServletRequest req){
        //查询所有船只信息、仓库信息，发给前端，让前端做选择
        //获取船只
        List<Ship> listShip = shipService.findAllShip();
        //获取仓库
        List<LandRepository> listLandRepository = matchingService.findAllLandRepository();
        req.setAttribute("listShip",listShip);
        req.setAttribute("listLandRepository",listLandRepository);
        return "matching/dischargeContainer";
    }
    //卸载货柜
    @RequestMapping(value="/dischargeContainer",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String dischargeContainer(String shipNo,
                                   Integer repositoryId,
                                   Integer idMin,Integer idMax){
        System.out.println("{discharge获取内容} "+shipNo+"||"+repositoryId+"||"+idMin+"||"+idMax);
        String json = matchingService.dischargeContainer(shipNo,repositoryId,idMin,idMax);
        return json;
    }
    //去到船只装载货柜页面
    @RequestMapping(value="/showLoad",produces="text/html;charset=UTF-8")
    public String showLoad(HttpServletRequest req) {
        //查询所有船只信息、仓库信息，发给前端，让前端做选择
        //获取船只
        List<Ship> listShip = shipService.findAllShip();
        //获取仓库
        List<LandRepository> listLandRepository = matchingService.findAllLandRepository();
        req.setAttribute("listShip",listShip);
        req.setAttribute("listLandRepository",listLandRepository);
        return "matching/loadContainer";
    }
    //装载货柜
    @RequestMapping(value="/loadContainer",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String loadContainer(String shipNo,
                                Integer repositoryId,
                                Integer idMin,Integer idMax){
        System.out.println("{load获取内容} "+shipNo+"||"+repositoryId+"||"+idMin+"||"+idMax);
        //去装载
        String json = matchingService.loadContainer(shipNo,repositoryId,idMin,idMax);
        return json;
    }

}
