package com.yzl.springboot.entity;

/**
 * @Author: 姚志立
 * @Date: 2020/4/1 21:05
 * @Version: 1.0
 */
public class User {
    private String username;
    //1代表女生 2代表男生
    private Integer gender;

    public User() {
    }

    public User(String username, Integer gender) {
        this.username = username;
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
