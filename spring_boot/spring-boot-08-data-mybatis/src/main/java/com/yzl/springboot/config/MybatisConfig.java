package com.yzl.springboot.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis的注解 版本相关的配置类
 * @Author: 姚志立
 * @Date: 2020/4/8 21:32
 * @Version: 1.0
 */
@Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        ConfigurationCustomizer configurationCustomizer=new ConfigurationCustomizer(){
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                //开启驼峰命名方式
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
        return configurationCustomizer;
    }
}
