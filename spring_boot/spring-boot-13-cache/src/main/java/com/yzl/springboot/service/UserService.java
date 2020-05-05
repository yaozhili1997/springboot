package com.yzl.springboot.service;

import com.yzl.springboot.entities.User;
import com.yzl.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * cacheNames 缓存名字
 * key:缓存容器中的key值，返回值是value值
 * @Author: 姚志立
 * @Date: 2020/4/12 10:44
 * @Version: 1.0
 */

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    //必须指定一个缓存名称，不指定报500错误
    @Cacheable(cacheNames = "user" ,key = "#id")
    public User getUserById(Integer id){
        User user = userMapper.getUserById(id);
        return user;
    }

    //必须指定一个缓存名称，不指定报500错误
    @CachePut(cacheNames = "user",key = "#result.id")
    public User updateUser(User user){
        userMapper.updateUser(user);
        return user;
    }

    //默认情况下删除数据不会讲缓存中的数据删除
    //allEntries = true 会将缓存中的所有数据清空
    //beforeInvocation = true 为true时候回先调用缓存清空
    @CacheEvict(cacheNames = "user",key = "#id")
    public  Integer deleteUserById(Integer id){
        userMapper.deleteUserById(id);
        return id;
    }
}
