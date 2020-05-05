package com.yzl.springboot.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @PropertySource 加载局部配置文件
 * @ConfigurationProperties 告诉springboot将配置文件中对应属性值，映射到这个组件的类中
 *进行一一绑定
 * prefix = "emp" 配置文件的前缀名，配置了哪个前缀就会与下面的左右属性进行一一映射
 * @Component 必须将当前组件作为SpringBoot中的一个组件来使用，这样才会纳入容器中管理
 * @Author: 姚志立
 * @Date: 2020/3/31 11:28
 * @Version: 1.0
 */

@PropertySource(value = {"classpath:emp.properties"})
@Validated//进行数据的合法性校验
@Component
@ConfigurationProperties(prefix = "emp" )

public class Emp {
    /*
     * 类似于Spring框架中使用配置文件中的数据注入方式`
    * <bean class=""Emp>
    *       <property name="lastname" value="字面量/#{SpEL} spring表达式/${key}从配置文件中获取"> </property》
    * */
//    @Value("${emp.lastname}")
//    @Email
    private String lastname;
//    @Value("#{10*2}")
    private  Integer age;
//    @Value("8000")
    private Double salary;
    private Boolean boss;
    private Date birthday;
//    @Value("emp.map")是不支持复杂类型的
    private Map map;
    private List list;

    private Forte forte;

    @Override
    public String toString() {
        return "Emp{" +
                "lastname='" + lastname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", boss=" + boss +
                ", birthday=" + birthday +
                ", map=" + map +
                ", list=" + list +
                ", forte=" + forte +
                '}';
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Forte getForte() {
        return forte;
    }

    public void setForte(Forte forte) {
        this.forte = forte;
    }
}
