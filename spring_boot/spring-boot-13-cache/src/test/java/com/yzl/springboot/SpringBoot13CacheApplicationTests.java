package com.yzl.springboot;

import com.yzl.springboot.entities.User;
import com.yzl.springboot.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

@SpringBootTest
class SpringBoot13CacheApplicationTests {
    //操作的是复杂类型 User
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate jsonRedisTemplate;

    //针对的都是操作字符串
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 五大数据类型
     * stringRedisTemplate.opsForValue();//操作字符串
     * stringRedisTemplate.opsForList();//操作List
     * stringRedisTemplate.opsForSet();//操作Set
     * stringRedisTemplate.opsForZSet();//操作ZSet
     * stringRedisTemplate.opsForHash();//操作Hash
     **/
    @Test
    void contextLoads() {
//        stringRedisTemplate.opsForValue().set("name","yzl");
        String name = stringRedisTemplate.opsForValue().get("name");
        System.out.println(name);
//        stringRedisTemplate.opsForList().leftPush("myList", "a");
//        stringRedisTemplate.opsForList().leftPushAll("myList", "a","b","c");
        List<String> myList = stringRedisTemplate.opsForList().range("myList", 0, -1);
        System.out.println(myList);
    }

    @Test
    public void testRedis() {
        User user = userService.getUserById(4);
        //保存的数据对象必须序列化 implement Serializable
        //因为redisTemplate 默认采用的是jdk序列化器
//        redisTemplate.opsForValue().set("user", user);
        User user1 = (User) redisTemplate.opsForValue().get("user");
        jsonRedisTemplate.opsForValue().set("user2", user);
        System.out.println(user1);
//        System.out.println(us);?
    }

}
