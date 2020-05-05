package com.yzl.springboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;

/**
 * @Author: 姚志立
 * @Date: 2020/4/13 15:57
 * @Version: 1.0
 */

@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<Object, Object> jsonRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer(Object.class));
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
