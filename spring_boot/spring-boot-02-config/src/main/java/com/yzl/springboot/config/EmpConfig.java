package com.yzl.springboot.config;

import com.yzl.springboot.service.EmpService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Configuration 它是spring里的注解，用于标识当前类时一个配置类，来表示对应的spring配置文件
 * @Author: 姚志立
 * @Date: 2020/3/31 16:40
 * @Version: 1.0
 */
@Configuration
public class EmpConfig {
    @Bean
    public EmpService empService2(){
        /*
        @Bean 标识的方法用于向容器中注入组件
        * 1.返回值就是注入容器中的组件对象
        * 2.方法名就是这个组件的id值
        * */
        System.out.println("EmpService组件注入成功");
        return new EmpService();
    }
}
