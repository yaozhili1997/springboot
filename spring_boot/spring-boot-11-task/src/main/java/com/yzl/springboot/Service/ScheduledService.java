package com.yzl.springboot.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * 创建定时任务
 * @Author: 姚志立
 * @Date: 2020/4/11 17:09
 * @Version: 1.0
 */
@Service
public class ScheduledService {
    private static int count=1;
    /*
    * second, minute, hour, day of month, month, and day of week.
     * <p>For example, {@code "0 * * * * MON-FRI"}
    * */
    @Scheduled(cron = "*/3 * * * * *")
    public void dataCount(){
        System.out.println("数据统计第"+count++ +"次");
    }
}
