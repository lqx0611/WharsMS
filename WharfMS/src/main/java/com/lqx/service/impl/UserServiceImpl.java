package com.lqx.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.lqx.mapper.UserMapper;
import com.lqx.pojo.User;
import com.lqx.pojo.UserExample;
import com.lqx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lqx.pojo.UserExample.Criteria;
import java.util.List;

/**
 * @author DUMBLEDOG
 * @date 2020/5/1 13:56
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public int insertUser(User user) {
        int i = userMapper.insert(user);
        return i;
    }
    @Override
    public User findUserByAccount(String account) {
        User user = userMapper.selectByAccount( account) ;
        return user;
    }
    @Override
    public String selectUserList(Integer pageNum,Integer pageSize) {
        UserExample uExp = new UserExample();
        Criteria cri = uExp.createCriteria();
        //cri.andIdIsNotNull();
        cri.andIdGreaterThan("0");  //0号管理员是不能被删除的，所以不显示,删除了就没人能登陆了
        PageHelper.startPage(pageNum,pageSize);
        List<User> list =userMapper.selectByExample(uExp);
        JSONObject jsObj = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        jsonArray.addAll(list);
        long count = userMapper.countByExample(null); //总记录数
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
    public String delUser(String id) {
        int ret = userMapper.deleteByPrimaryKey(id);
        if(ret==1){
            return "success";
        }
        return "failed";
    }

    @Override
    public User findUserById(String id) {
        User dbUser = userMapper.selectByPrimaryKey(id);
        return dbUser;
    }


}
