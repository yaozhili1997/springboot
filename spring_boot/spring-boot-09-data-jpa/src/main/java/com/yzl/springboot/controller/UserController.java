package com.yzl.springboot.controller;

import com.yzl.springboot.dao.UserRepository;
import com.yzl.springboot.entity.User;
import com.yzl.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @Author: 姚志立
 * @Date: 2020/4/9 10:04
 * @Version: 1.0
 */

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id")Integer id){
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.get();
        return user;
    }

    @GetMapping("/user")
    public User addUser(User user){
        User user1 = userRepository.save(user);
        return user1;
    }

    @Autowired//注意，面向接口编程，这里注入的是接口，来来实现功能
    IUserService userService;
    @GetMapping("/user2")
    public User addUser2(User user){
        userService.addUser(user);
        return user;
    }
}
