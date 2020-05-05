package com.yzl.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 姚志立
 * @Date: 2020/4/7 16:03
 * @Version: 1.0
 */
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String execute(){
        return "hello world";
    }
}
