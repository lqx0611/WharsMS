package com.lqx.service;

import com.alibaba.fastjson.JSONArray;
import com.lqx.pojo.User;

import java.util.List;

/**
 * @author DUMBLEDOG
 * @date 2020/5/1 13:56
 */
public interface UserService {
   int insertUser(User user);
   User findUserByAccount(String account);
   String selectUserList(Integer pageNum,Integer pageSize);
   String delUser(String id);

   User findUserById(String id);
}
