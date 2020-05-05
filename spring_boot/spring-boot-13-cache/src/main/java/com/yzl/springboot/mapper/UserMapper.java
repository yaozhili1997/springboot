package com.yzl.springboot.mapper;

import com.yzl.springboot.entities.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Author: 姚志立
 * @Date: 2020/4/12 10:33
 * @Version: 1.0
 */
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    User getUserById(Integer id);

    @Update("UPDATE `user`\n" +
        "        SET `username`=#{username}, `real_name`=#{realName},\n" +
        "        `password`=#{password}, `gender`=#{gender}, `birthday`=#{birthday},\n" +
        "        `user_type`=#{userType}\n" +
        "        WHERE `id`=#{id}")
    int updateUser(User user);

    @Insert("INSERT INTO `user` ( `username`, `real_name`, `password`, `gender`, `birthday`, `user_type`)\n" +
            "        VALUES ( #{username}, #{realName}, #{password}, #{gender}, #{birthday}, #{userType})")
    int addUser(User user);

    @Delete("delete from `user` where id = #{id}")
    int deleteUserById(Integer id);


}
