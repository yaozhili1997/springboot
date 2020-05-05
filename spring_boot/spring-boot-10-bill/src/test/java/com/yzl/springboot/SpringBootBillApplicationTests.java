package com.yzl.springboot;

import com.yzl.springboot.entities.Bill;
import com.yzl.springboot.entities.BillProvider;
import com.yzl.springboot.entities.Provider;
import com.yzl.springboot.entities.User;
import com.yzl.springboot.mapper.BillMapper;
import com.yzl.springboot.mapper.ProviderMapper;
import com.yzl.springboot.mapper.UserMapper;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.security.RunAs;
import java.util.List;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootBillApplicationTests {

    @Autowired
    ProviderMapper providerMapper;

    @Test
    public void testProvider() {
        Provider p = new Provider();
        p.setProviderName("A货");
        List<Provider> providers = providerMapper.getProviders(p);
        System.out.println(providers.get(0));

        Provider provider = providerMapper.getProviderByPid(2);
        System.out.println(provider);

        provider.setProviderName("b货最棒");
        int i = providerMapper.updateProvider(provider);
        System.out.println(i);

//        providerMapper.addProvider(new Provider(null, "PR-EE", "码海淹没的小强作业555", "小谷", "18888666985", "深圳软件园", "0911-0123452", "品质E"));
        providerMapper.deleteProviderByPid(10);
    }

    @Autowired
    BillMapper billMapper;

    @Test
    public void testBill() {
        Bill b = new Bill();
        billMapper.getBills(b);
        b.setBillName("com");
        List<BillProvider> bills = billMapper.getBills(b);
        System.out.println(bills.get(0));

        BillProvider billProvider = billMapper.getBillByBid(4);
        System.out.println(billProvider);

        Bill bill = (Bill) billProvider;
        bill.setBillName("cn域名。。。。");
        billMapper.updateBill(bill);

//        billMapper.addBill(new Bill(3001,"Bi-666", "粮油aaa", "斤", 80,480.8, new Provider(2002, "PR-BB", "码海淹没的小强作业222", "小李", "18888666982", "深圳软件园", "0911-0123453", "品质B"), 1));
        billMapper.deleteBillByBid(5);


    }

    @Autowired
    UserMapper userMapper;

    @Test
    public void testUser() {
        User u = new User();
        u.setUsername("zhang");
        List<User> users = userMapper.getUsers(u);
        System.out.println(users.get(0));
        User user = userMapper.getUserById(1);
        System.out.println(user);
        user.setUsername("admin");
        int size = userMapper.updateUser(user);
        System.out.println(size);
        billMapper.deleteBillByBid(4);
    }
}
