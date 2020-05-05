package com.yzl.springboot.mapper;

import com.yzl.springboot.entities.Provider;

import java.util.List;

/**
 * @Author: 姚志立
 * @Date: 2020/4/9 15:56
 * @Version: 1.0
 */

//@Mapper或@MapperScan("com.yzl.springboot.mapper")
public interface ProviderMapper {
    List<Provider>getProviders(Provider provider);
    Provider getProviderByPid(Integer pid);
    int addProvider(Provider provider);
    int deleteProviderByPid(Integer pid);
    int updateProvider(Provider provider);
}
