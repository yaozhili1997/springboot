package com.yzl.springboot.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 异步处理批量操作
 * @Author: 姚志立
 * @Date: 2020/4/11 15:03
 * @Version: 1.0
 */
@Async
@Service
public class AsyncService {
    public void batchAdd() {
        try {
            //模拟新增数据
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("批量更新数据完成");
    }
}
