package com.yzl.springboot;

import com.yzl.springboot.bean.Emp;
import com.yzl.springboot.service.EmpService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot02ConfigApplicationTests {
    @Autowired
    Emp emp;

    @Autowired
    ApplicationContext context;

    @Test
    public void textXml(){
//        EmpService empService = (EmpService) context.getBean("empService");
//        System.out.println(empService);
//        empService.add();
        EmpService empService2 = (EmpService) context.getBean("empService2");
        System.out.println("empService2:"+empService2);
    }
    @Test
    void contextLoads() {
        System.out.println(emp);
    }

}
