package com.yzl.springboot.controller;

import com.yzl.springboot.entities.Provider;
import com.yzl.springboot.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 姚志立
 * @Date: 2020/4/8 20:52
 * @Version: 1.0
 */
@RestController
public class ProviderController {
    @Autowired
    ProviderMapper providerMapper;
    @GetMapping("/provider/{pid}")
    public Provider getProvider(@PathVariable("pid")Integer pid){
        Provider provider = providerMapper.getProviderByPid(pid);
        return provider;
    }

    @GetMapping("/provider")
    public Provider addProvider(Provider provider){
        providerMapper.addProvider(provider);
        return provider;
    }
}
