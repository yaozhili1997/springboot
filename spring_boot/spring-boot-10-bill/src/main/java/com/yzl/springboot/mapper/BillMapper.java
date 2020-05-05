package com.yzl.springboot.mapper;

import com.yzl.springboot.entities.Bill;
import com.yzl.springboot.entities.BillProvider;
import com.yzl.springboot.entities.Provider;

import java.util.List;

/**
 * @Author: 姚志立
 * @Date: 2020/4/9 15:56
 * @Version: 1.0
 */

//@Mapper或@MapperScan("com.yzl.springboot.mapper")
public interface BillMapper {
    List<BillProvider>getBills(Bill bill);
    BillProvider getBillByBid(Integer bid);
    int addBill(Bill bill);
    int updateBill(Bill bill);
    int deleteBillByBid(Integer bid);
}
