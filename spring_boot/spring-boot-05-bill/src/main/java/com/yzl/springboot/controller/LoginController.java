package com.yzl.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: 姚志立
 * @Date: 2020/4/3 12:14
 * @Version: 1.0
 */
@Controller
public class LoginController {
    @PostMapping("/login")
    public String login(HttpSession session,String username, String password, Map<String,Object>map) {
        //判断用户名不为空，且密码为123 登陆成功
        if (!StringUtils.isEmpty(username) && "123".equals(password)) {
            session.setAttribute("loginUser", username);
            //登陆成功
            //重定向：可以重定向到任意一个请求中（包含其他项目，地址栏改变）；转发就不会改变
            return "redirect:/main.html";
        }
            //都登陆失败
        map.put("msg", "用户名或密码错误");
        return "main/login";
    }

    //退出登陆
    @GetMapping("/logout")
    public String logout(HttpSession session){
        //1.清空session中的用户信息
        session.removeAttribute("loginUser");
        //2.再将session进行注销
        session.invalidate();
        //3.返回的的登陆页面
        return "redirect:/index.html";
    }
}
