package com.yzl.springboot.service.impl;

import com.yzl.springboot.dao.UserRepository;
import com.yzl.springboot.entity.User;
import com.yzl.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 模拟事务管理
 * @Author: 姚志立
 * @Date: 2020/4/9 10:58
 * @Version: 1.0
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserRepository userRepository;
    //isolation 指定隔离级别，propagation指定传播行为
    @Transactional(isolation = Isolation.DEFAULT,propagation= Propagation.REQUIRED)//开启当前方法的事务管理
    @Override
    public Boolean addUser(User user) {
        userRepository.save(new User("0","0"));
        userRepository.save(new User("2","12"));
        userRepository.save(new User("3","123"));
        userRepository.save(new User("4","1234"));
        userRepository.save(new User("5","12345"));

        //转入：模拟失败了
//        userRepository.save(new User("123456","6"));
//        userRepository.save(new User("1234567","7"));
        userRepository.save(user);
        return null;
    }
}
