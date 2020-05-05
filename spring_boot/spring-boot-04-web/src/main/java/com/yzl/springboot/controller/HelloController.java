package com.yzl.springboot.controller;

import com.yzl.springboot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: 姚志立
 * @Date: 2020/4/1 11:04
 * @Version: 1.0
 */
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/success")
    public String execute(){
        return "hello yzl";
    }

    @RequestMapping("/execute")
    public String success(Map<String,Object> map){
        map.put("name", "yzl");
        //classpath:/templates/success.html
        return "success";
    }

    @RequestMapping("/study")
    public String study(Map<String,Object>map, HttpServletRequest request){
        List<User>userList=new ArrayList<>();
        userList.add(new User("小梦",1));
        userList.add(new User("小李",2));
        userList.add(new User("小张",1));
        map.put("userList",userList);

        map.put("sex",1);//1女 2男
        map.put("desc", "欢迎来到<h1>成都欢乐谷<h1>");
        /*将user对象绑定到session中*/
        request.getSession().setAttribute("user", new User("小刘",2));
        return "study";
    }
}
