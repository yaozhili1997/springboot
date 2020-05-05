package com.yzl.springboot.mapper;

import com.yzl.springboot.entities.Provider;
import org.apache.ibatis.annotations.*;

/**
 * 使用mybatis的注解版本
 * @Author: 姚志立
 * @Date: 2020/4/8 20:20
 * @Version: 1.0
 */
//@Mapper 指定只是操作数据的Mapper
public interface ProviderMapper {
    @Select("select * from provider where pid=#{pid}")
    Provider getProviderByPid(Integer pid);

    //useGeneratedKeys是否使用自增主键，keyProperty 指定哪一个实体类中的属性封装主键
    @Options(useGeneratedKeys = true,keyProperty = "pid")
    @Insert("insert into provider(providerName) values(#{providerName})")
    int addProvider(Provider provider);

    @Delete("delete from provider where pid=#{pid}")
    int deleteProvider(Integer pid);

    @Update("update provider set providerName=#{providerName} where pid=#{pid}")
    int updateProvider(Provider provider);

}
