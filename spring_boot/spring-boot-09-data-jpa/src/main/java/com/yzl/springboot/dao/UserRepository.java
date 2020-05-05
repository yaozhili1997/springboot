package com.yzl.springboot.dao;

import com.yzl.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 自定义接口继承JpaRepository，就会有crud操作切分页排序 等功能
 * @Author: 姚志立
 * @Date: 2020/4/9 9:50
 * @Version: 1.0
 */
//指定的泛型<操作实体类，主键的数据类型>
public interface UserRepository extends JpaRepository<User,Integer> {
}
