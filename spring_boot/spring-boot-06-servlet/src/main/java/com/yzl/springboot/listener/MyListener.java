package com.yzl.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 自定义listener组件
 * 测试的是关于应用的启动与关闭
 * @Author: 姚志立
 * @Date: 2020/4/6 20:46
 * @Version: 1.0
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Springboot.Servlet应用启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Springboot.Servlet应用销毁");
    }
}
