package com.yzl.springboot.controller;

import com.yzl.springboot.entities.Bill;
import com.yzl.springboot.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 姚志立
 * @Date: 2020/4/8 23:27
 * @Version: 1.0
 */
@RestController
public class BillController {
    @Autowired
    BillMapper billMapper;
    @GetMapping("/bill/{bid}")
    public Bill getBill(@PathVariable("bid")Integer bid){
        Bill bill = billMapper.getBillByBid(bid);
        return bill;
    }
    @GetMapping("/bill")
    public Bill addBill(Bill bill){
        int i = billMapper.addBill(bill);
        return bill;

    }
}
