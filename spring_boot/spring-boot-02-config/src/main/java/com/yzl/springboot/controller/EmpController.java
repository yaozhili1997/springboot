package com.yzl.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 姚志立
 * @Date: 2020/3/31 16:10
 * @Version: 1.0
 */
@Controller
public class EmpController {
    @Value("${emp.lastname}")
    private String name;
    @ResponseBody
    @RequestMapping("/say")
    public String sayHello(){
        return "say hello"+name;
    }
}
