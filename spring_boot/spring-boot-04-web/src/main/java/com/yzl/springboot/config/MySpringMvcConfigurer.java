package com.yzl.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *创建一个WebMvcConfigurer类型的子类
 * 类上用@Configuration标识它是一个配置类
 * 不能使用@EnableWebMvc进行标识
 *
 * @Author: 姚志立
 * @Date: 2020/4/2 10:44
 * @Version: 1.0
 */
//完全掌控springMVC，不建议使用
//@EnableWebMvc
@Configuration
public class MySpringMvcConfigurer implements WebMvcConfigurer  {
    //增加视图控制
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //发送/new 请求 会来到success.html
        registry.addViewController("/new").setViewName("success");
    }
}
