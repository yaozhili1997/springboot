package com.yzl.springboot.mapper;

import com.yzl.springboot.entities.User;
import java.util.List;


/**
 * @Author: 姚志立
 * @Date: 2020/4/2 13:31
 * @Version: 1.0
 */
public interface UserMapper {

    User getUserByUsername(String username);

    List<User> getUsers(User user);

    User getUserById(Integer id);

    int addUser(User user);

    int deleteUserById(Integer id);

    int updateUser(User user);

}
