package com.yzl.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//会自动装配指定包下面所有的Mapper，省得在每个Mapper上面写@Mapper
@MapperScan("com.yzl.springboot.mapper")
@EnableTransactionManagement//开启注解的事务管理
@SpringBootApplication
public class SpringBoot08DataMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot08DataMybatisApplication.class, args);
    }

}
