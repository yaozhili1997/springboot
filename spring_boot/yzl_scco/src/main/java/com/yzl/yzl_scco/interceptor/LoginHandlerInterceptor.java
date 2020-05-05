package com.yzl.yzl_scco.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义登陆拦截器
 *
 * @Author: 姚志立
 * @Date: 2020/4/3 14:39
 * @Version: 1.0
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    //调用目标方法之前拦截
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser!=null){
            //已经登陆过，放行
            return true;
        }
        request.setAttribute("msg", "没有权限，请先进行登陆");
        request.getRequestDispatcher("/index.html").forward(request, response);
        return false;
    }
}
