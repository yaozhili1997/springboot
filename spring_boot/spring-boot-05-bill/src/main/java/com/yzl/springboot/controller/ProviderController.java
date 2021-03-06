package com.yzl.springboot.controller;

import com.yzl.springboot.dao.ProviderDao;
import com.yzl.springboot.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * @Author: 姚志立
 * @Date: 2020/4/2 13:31
 * @Version: 1.0
 */
@Controller
public class ProviderController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    ProviderDao providerDao;

    //@RequestMapping(value = "/providers",method = RequestMethod.GET)
    @GetMapping("/providers")
    public String list(Map<String, Object> map, @RequestParam(value = "providerName", required = false) String providerName) {
        logger.info("作业被查询了" + providerName);
        Collection<Provider> providers = providerDao.getAll(providerName);
        map.put("providers", providers);
        map.put("providerName",providerName);//查询输入框回显刚才查询的内容
        //classpath:/templates/
        //classpath:/templates/provider/list.html
        return "provider/list";
    }

    /**
     * 查看某个作业详情
     * type=null 默认view详情页面，type=update 修改页面
     */
    @GetMapping("/provider/{pid}")
    public String view(@RequestParam(value = "type", defaultValue = "view")String type,
                       @PathVariable("pid") Integer pid,
                       Map<String, Object> map) {
        logger.info("查询"+pid+"的供应商消息");
        Provider provider = providerDao.getProvider(pid);
        map.put("provider", provider);
        // type=null 默认view详情页面，type=update 修改页面
        return "provider/" + type;
    }

    //修改作业信息
    @PutMapping("/provider")
    public String update(Provider provider) {
        logger.info("更新作业信息: " + provider);
        providerDao.save(provider);
        //重定向到列表页
        return "redirect:/providers";
    }

    //前往添加页面
    @GetMapping("/provider")
    public String toAddPage(){
        return "provider/add";
    }

    //添加数据
    @PostMapping("/provider")
    public String add(Provider provider){
        logger.info("添加作业数据"+provider);
        //保存数据操作
        providerDao.save(provider);
        return "redirect:/providers";
    }

    @DeleteMapping("/provider/{pid}")
    public String delete(@PathVariable("pid")Integer pid){
        logger.info("删除操作，pid="+pid);
        providerDao.delete(pid);
        return "redirect:/providers";
    }
}
