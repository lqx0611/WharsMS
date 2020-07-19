package com.lqx.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author DUMBLEDOG
 * @date 2020/5/11 21:37
 */
public interface NotifyService {
    //1、展示公告列表 返回json字符串
    String showNotifyList();
    //2、上传公告
    String uploadNotify(MultipartFile file, String title, String description,String uploader);
    //3、下载公告
    ResponseEntity<byte[]> downNotify(String fileName) throws IOException;


    String delNotify(String id);
}
