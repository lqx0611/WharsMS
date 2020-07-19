package com.lqx.service.impl;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lqx.mapper.NotifyMapper;
import com.lqx.pojo.Notify;
import com.lqx.pojo.NotifyExample;
import com.lqx.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLEncoder;

import java.io.File;
import java.util.List;

/**
 * @author DUMBLEDOG
 * @date 2020/5/11 21:42
 */
@Service
public class NotifyServiceImpl implements NotifyService {
    @Autowired
    NotifyMapper notifyMapper;

    private String uploadDir = "F:\\apk\\notify\\";

    @Override
    public String showNotifyList() {
        NotifyExample nExp = new NotifyExample();
        NotifyExample.Criteria cri = nExp.createCriteria();
        cri.andIdIsNotNull();
        //List<Ship> listShip = shipMapper.selectByExample(sExp);
        List<Notify> listNotify = notifyMapper.selectByExample(nExp);
        JSONObject jsObj = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        int count = 0; //总记录数
        for (Notify notify : listNotify) {
            jsonArray.add(notify);
            System.out.println( notify );
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
    public String uploadNotify(MultipartFile file, String title, String description,String uploader) {
        Notify notify = new Notify();
        //{1} 获取文件的名称等其他信息保存到公告列表
        String fName = file.getOriginalFilename();
        notify.setUploader(uploader);
        notify.setFileName(fName);
        notify.setTitle(title);
        notify.setDescription(description);
        //{2} 拼接文件的上传目标路径
        String filePath = uploadDir + fName;
        try {
            file.transferTo( new File( filePath ) );
        } catch (IllegalStateException | IOException e) {
            return "上传失败.";
        }
        notifyMapper.insert(notify);
        return "公告已发布";

    }


    @Override
    public ResponseEntity<byte[]> downNotify(String fileName) throws IOException {
            //{ps} 构造器的格式:
            //ResponseEntity( byte[] 文件数据,
            //		MultiValueMap 响应头部,
            //		HttpStatus Http状态码(枚举) );
            File file = new File( uploadDir + fileName );
            //{1} 读取文件的数据到  buff 数组。
            byte[] buff = FileUtils.readFileToByteArray( file );
            //{2} Http 头部封装对象。
            HttpHeaders headers = new HttpHeaders();
            //{3} 取得一个编码后的文件名
            String encName = URLEncoder.encode(fileName,"UTF-8");
            //{3} 添加响应头部信息。
            //{ps} 响应头的内容类型, 有些浏览器要识别你这个数据是一个下载文件。
            //     如果 ie 就会一个框。。
            headers.add("Content-Type", "application/ms-xdownload");
            //{ps} 告诉浏览器这是一个附件, 文件名是什么嘛 。
            headers.add("Content-Disposition",
                    "attachment;filename="+ encName );
            ResponseEntity<byte[]> entitry =
                    new ResponseEntity<byte[]>(
                            buff, headers, HttpStatus.OK );
            return entitry;
    }

    @Override
    public String delNotify(String id) {
        Integer _id = Integer.valueOf(id);
        notifyMapper.deleteByPrimaryKey(_id);
        //是否要在文件夹删除？
        // ...
        return "success";
    }
}
