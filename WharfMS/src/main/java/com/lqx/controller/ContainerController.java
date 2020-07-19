package com.lqx.controller;

import com.alibaba.fastjson.JSONObject;
import com.lqx.pojo.Container;
import com.lqx.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpSession;

/**
 * @author DUMBLEDOG
 * @date 2020/5/3 23:38
 */
@Controller
@RequestMapping("/Container")
public class ContainerController {
    @Autowired
    ContainerService containerService;

    //显示在仓货柜列表
    @RequestMapping(value="/showContainerList",produces="text/html;charset=UTF-8")
    public String showContainerList(HttpSession session){
        session.setAttribute("repositoryId",0);
        return "container/repositoryList";
    }
    //选择仓库
    @RequestMapping(value="/showContainerList2",produces="text/html;charset=UTF-8")
    public String showContainerList2(HttpSession session, @RequestParam("repositoryId") Integer repositoryId){
        session.setAttribute("repositoryId",repositoryId);
        return "container/repositoryList";
    }
    @RequestMapping(value = "/containerList",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String containerList(@RequestParam("page") Integer pageNum,
                                @RequestParam("limit") Integer pageSize,
                                @RequestParam("repositoryId")Integer repositoryId){
        String json = containerService.showContaineList(pageNum,pageSize,repositoryId);
        return  json;
    }
    @RequestMapping("/showPutToRepository")
    public String showPutToRepository(){
        return "container/putToRepository";
    }
    @RequestMapping(value="/putToRepository",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String putToRepository(String type,int repositoryId,int count){
        System.out.println("+----------获取到前端传来的信息----------+");
        System.out.println(type);
        System.out.println(repositoryId);
        System.out.println(count);
        System.out.println("+----------------------------+");
        Container container = new Container();
        container.setType(type);
        container.setRepository(repositoryId);
        //判断是哪个类型的
        if(type.equals("小型货柜")){
            container.setShipType("小型货轮");
            container.setCapacity(30);
        }else if(type.equals("中型货柜")){
            container.setShipType("中型货轮");
            container.setCapacity(50);
        }else {
            container.setShipType("大型货轮");
            container.setCapacity(80);
        }
        String json = containerService.putToRepository(container,repositoryId,count);
        return json;
    }
}
