package com.lqx.controller;

import com.alibaba.fastjson.JSONObject;
import com.lqx.pojo.User;
import com.lqx.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author DUMBLEDOG
 * @date 2020/5/11 21:36
 */
@Controller
@RequestMapping("/Notify")
public class NotifyController {
    @Autowired
    NotifyService notifyService;

    //公告列表
    @RequestMapping(value="/showNotifyList",produces="text/html;charset=UTF-8")
    public String showNotifyList(){
        return "notify/notifyList";
    }
    @RequestMapping(value="/notifyList",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String notifyList(){
        return notifyService.showNotifyList();
    }

    //去上传公告
    @RequestMapping(value="/showUploadNotify",produces="text/html;charset=UTF-8")
    public String showUploadNotify(){
        return "notify/uploadNotify";
    }
    //上传公告
    @RequestMapping(value="/uploadNotify",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String uploadNotify(@RequestParam("uploadFile")MultipartFile file,
                               @RequestParam("title")String title,
                               @RequestParam("description")String description,
                               HttpSession session){
        User user = (User)session.getAttribute("user");
        String uploader = user.getName();
        return notifyService.uploadNotify(file,title,description,uploader);
    }
    @RequestMapping(value="/downNotify",produces="text/html;charset=UTF-8")
    private ResponseEntity<byte[]> downNotify(String fileName) throws IOException {
        System.out.println("#### fileName =="+fileName);
        return notifyService.downNotify(fileName);
    }


    @RequestMapping(value="/delNotify",produces="text/html;charset=UTF-8")
    @ResponseBody
    private String delNotify(HttpServletRequest request) throws IOException {
        JSONObject json = new JSONObject();
        String id =  request.getParameter("id");
        String ret = notifyService.delNotify(id);
        json.put("result",ret);
        return  json.toJSONString();
    }
}
