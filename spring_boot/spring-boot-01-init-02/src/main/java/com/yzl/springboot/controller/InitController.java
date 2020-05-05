package com.yzl.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 姚志立
 * @Date: 2020/3/30 23:38
 * @Version: 1.0
 */
@RestController
public class InitController {
    @RequestMapping("/info")
    public String init(){
        return "hello init";
    }
}
