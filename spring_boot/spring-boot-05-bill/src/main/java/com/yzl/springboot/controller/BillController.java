package com.yzl.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: 姚志立
 * @Date: 2020/4/6 11:15
 * @Version: 1.0
 */
@Controller
public class BillController {
    @GetMapping("/bills")
    public String list(){
        //模拟500错误
//        int i=1/0;
        //模拟运行时异常
        int i=0;
        if(i==0){
            throw new RuntimeException("i不能为零");
        }
        return "bill/list";
    }
}
