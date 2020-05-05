package com.yzl.springboot.entity;

import javax.persistence.*;

/**
 * jpa采用的orm（对象关系映射）模型
 * @Author: 姚志立
 * @Date: 2020/4/9 9:37
 * @Version: 1.0
 */

@Entity//说明 它是和数据表映射的类
@Table(name = "tbl_user")//指定对应映射的表名，省略不写默认表名是类同 user
public class User {
    @Id //指定主键
    //设置为主键自增长
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name",length = 5)//与数据表对应的字段
    private String username;
    @Column//省略不写默认字段名就是属性名
    private String password;

    public User() {
    }
    public User(String username,String password){
        this.username=username;
        this.password=password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
