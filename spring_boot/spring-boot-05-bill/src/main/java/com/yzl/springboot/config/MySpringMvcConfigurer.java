package com.yzl.springboot.config;

import com.yzl.springboot.component.MyLocaleResolver;
import com.yzl.springboot.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: 姚志立
 * @Date: 2020/4/2 15:29
 * @Version: 1.0
 */

@Configuration
public class MySpringMvcConfigurer {
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            //添加了视图控制器
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("main/login");
                registry.addViewController("/index.html").setViewName("main/login");
                registry.addViewController("/main.html").setViewName("main/index");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginHandlerInterceptor())
                        //指定要拦截的请求 /**表示拦截所有请求
                        .addPathPatterns("/**")
                        //排除不需要拦截的请求路径
                        .excludePathPatterns("/", "/login", "/index.html")
                        //springboot2+之后需要将静态资源文件的访问路径也排除掉
                        .excludePathPatterns("/css/*","/img/*","/js/*")
                        .excludePathPatterns("/favicon.ico");
            }
        };
    }

    //区域解析器
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
