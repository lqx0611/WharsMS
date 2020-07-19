package com.lqx.interceptor;

import com.lqx.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author DUMBLEDOG
 * @date 2020/5/2 13:32
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        System.out.println("{LoginInterceptor} 20L 拦截下来的User："+ user);
        if(user!=null){
            return true;
        }
        session.setAttribute("msg","请先登录！");
        request.getRequestDispatcher("/User/showLogin").forward(request,response);
        return false;
    }

}
