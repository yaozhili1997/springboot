package com.yzl.springboot.mapper;

import com.yzl.springboot.entities.Bill;

/**
 * @Author: 姚志立
 * @Date: 2020/4/8 21:54
 * @Version: 1.0
 */
public interface BillMapper {
    Bill getBillByBid(Integer bid);

    int addBill(Bill bill);


}
