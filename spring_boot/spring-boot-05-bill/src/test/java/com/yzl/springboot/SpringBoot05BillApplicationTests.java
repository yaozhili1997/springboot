package com.yzl.springboot;

import com.yzl.springboot.dao.ProviderDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot05BillApplicationTests {
    @Autowired
    ProviderDao providerDao;
    @Test
    void contextLoads() {
//        System.out.println(providerDao.getAll());
        System.out.println(providerDao.getAll("码海淹没的小强作业111"));
    }

}
