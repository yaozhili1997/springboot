package com.yzl.springboot.controller;

import com.yzl.springboot.Service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 姚志立
 * @Date: 2020/4/11 16:35
 * @Version: 1.0
 */
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;
    @GetMapping("/hello")
    public String hello(){
        asyncService.batchAdd();

        return "success";

    }
}
