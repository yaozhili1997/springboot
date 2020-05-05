package com.yzl.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @SpringBootApplication 用于标识，一个引导类 说明：当前是一个SpringBoot项目
 * @Author: 姚志立
 * @Date: 2020/3/30 15:24
 * @Version: 1.0
 */

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello World";
    }
}
