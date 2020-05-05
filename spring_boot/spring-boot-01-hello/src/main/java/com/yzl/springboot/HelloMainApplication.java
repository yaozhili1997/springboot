package com.yzl.springboot;


import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.run;


/**
 * @Author: 姚志立
 * @Date: 2020/3/30 15:28
 * @Version: 1.0
 */

/*
* @SpringBootConfiguration
*   @Configuration 它属于spring中的一个注解，定义配置类，等价于配置文件
*       @Component 添加到spring容器中，表示 是一个组件
* @EnableAutoConfiguration
*       @AutoConfigurationPackage 将引导类所在包及其子包下面所有的组件添加到spring容器中
        @Import(AutoConfigurationImportSelector.class)
        * 将所有主组件以全类名的方式返回，并且添加到spring容器中
        * 会给容器中导入非常多的自动配置类（*****AutoConfiguration），就是导入并配置好很多当前项目中多有需要的组件
        * 省去我们手动编写配置然后注入到组件中
* @ComponentScan
* 被该注解标识的类，会被spring容器进行管理
* */
@SpringBootApplication
public class HelloMainApplication {
    public static void main(String[] args) {
        run(HelloMainApplication.class,args);
    }
}
