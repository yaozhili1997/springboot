package com.yzl.springboot.bean;

/**
 * @Author: 姚志立
 * @Date: 2020/3/31 11:32
 * @Version: 1.0
 */
public class Forte {
    private String name;
    private Integer time;

    @Override
    public String toString() {
        return "Forte{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
