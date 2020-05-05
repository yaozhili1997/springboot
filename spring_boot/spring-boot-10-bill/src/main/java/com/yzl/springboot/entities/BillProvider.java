package com.yzl.springboot.entities;

/**
 * 封装新的实体，因为分数列表还有详情都要有作业的名称
 * @Author: 姚志立
 * @Date: 2020/4/10 11:25
 * @Version: 1.0
 */
public class BillProvider extends Bill {
    private String providerName;

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
