package com.lqx.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lqx.pojo.User;
import com.lqx.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

/**
 * @author DUMBLEDOG
 * @date 2020/5/1 13:53
 */
@Controller
@RequestMapping("/User")
public class UserController {
    private static final String SYS_ADMIN = "1";
    private static final String ORDINARY_ADMIN = "2";
    @Autowired
    UserService userService;

    /**
     * @function: 跳转到登录页面
     * @return
     */
    @RequestMapping("/showLogin")
    public String viewLogin(){
        return "user/login";
    }

    /**
     * @function 登录操作，把登录的 user 设置到页面会话域
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam("account") String account,
                        @RequestParam("password") String password,
                        @RequestParam("roleId") String roleId,
                        HttpSession session){
        User dbUser = userService.findUserByAccount(account);
        System.out.println("dbUser"+dbUser); //test
        if(dbUser!=null){
            if(password.equals(dbUser.getPassword())) {
                if(dbUser.getRoleId().equals(roleId)){
                    if(roleId.equals(SYS_ADMIN)){
                        session.setAttribute("user",dbUser);
                        return "mainSys";  //跳转到系统管理员主页
                    }
                    if(roleId.equals(ORDINARY_ADMIN)){
                        session.setAttribute("user",dbUser);
                        return "main";  //跳转到普通管理员主页
                    }
                }
            }
        }
        return "redirect:/loginFailed.jsp";
    }

    /**
     * @method: logout()
     * @function: 退出登录，并把会话域信息清空
     * @address: /User/logout
     * @return
     */

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.jsp";
    }
    /**
     * @method: showUserList()
     * @function: 跳转到用户列表
     * @address: /User/showUserList
     * @return
     */
    @RequestMapping("/showUserList")
    public String showUserList(){
        return "user/userList";
    }
    @RequestMapping(value="/userList",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String userList(@RequestParam("page") Integer pageNum,
                           @RequestParam("limit") Integer pageSize){
        return userService.selectUserList(pageNum,pageSize);
    }
    /**
     * @method: showAddUser()
     * @function: 跳转到添加用户界面
     * @address: /User/showAddUser
     * @return
     */
    @RequestMapping("/showAddUser")
    public String showAddUser(){
        return "user/addUser";
    }

    /**
     * @function 增加管理员
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(User user){
        System.out.println("添加："+user);
        User dbUser = userService.findUserByAccount(user.getAccount());
        if(dbUser!=null){
            return "user/addFailed";
        }
        User dbUser2 = userService.findUserById(user.getId());
        if( dbUser2!=null ){
            return "user/addFailed";
        }
        if(user.getRoleId().equals(SYS_ADMIN)){
            user.setRole("系统管理员");
        }else {
            user.setRole("普通管理员");
        }
        userService.insertUser(user);
        return "user/userList";
    }

    @RequestMapping("/delUser")
    @ResponseBody
    public String delUser(HttpServletRequest request){
        JSONObject json = new JSONObject();
        String id = request.getParameter("id");
        String ret = userService.delUser(id);
        json.put("result",ret);
        return  json.toJSONString();
    }

//
//    @RequestMapping("/testAjax")
//    public String testAjax(@RequestBody String str){
//        System.out.println(str);
//        return "test";
//    }
}
