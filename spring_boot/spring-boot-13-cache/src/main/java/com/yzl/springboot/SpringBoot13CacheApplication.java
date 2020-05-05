package com.yzl.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
/**
 * 0 = "org.springframework.boot.autoconfigure.cache.GenericCacheConfiguration"
 * 1 = "org.springframework.boot.autoconfigure.cache.JCacheCacheConfiguration"
 * 2 = "org.springframework.boot.autoconfigure.cache.EhCacheCacheConfiguration"
 * 3 = "org.springframework.boot.autoconfigure.cache.HazelcastCacheConfiguration"
 * 4 = "org.springframework.boot.autoconfigure.cache.InfinispanCacheConfiguration"
 * 5 = "org.springframework.boot.autoconfigure.cache.CouchbaseCacheConfiguration"
 * 6 = "org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration"
 * 7 = "org.springframework.boot.autoconfigure.cache.CaffeineCacheConfiguration"
 * 8 = "org.springframework.boot.autoconfigure.cache.SimpleCacheConfiguration"[默认缓存]
 * 9 = "org.springframework.boot.autoconfigure.cache.NoOpCacheConfiguration"
 * 分析源码：
 * 1.默认采用的是SimpleCacheConfiguration 使用 ConcurrentMapCacheManager
 * 2. getCache 获取的是 ConcurrentMapCache 缓存对象进行存取数据,它使用ConcurrentMap<Object, Object>对
 象进行缓存数据
 * @Cacheable(cacheNames = "user")
 * 第一次请求时:
 * 3.当发送第一次请求时,会从cacheMap.get(name)中获取有没有ConcurrentMapCache缓存对象,如果没有则创建
出来,
 * 并且创建出来的key就是通过@Cacheable(cacheNames = "user")标识的name值
 * 4.接着会从ConcurrentMapCache里面调用lookup获取缓存数据,通过key值获取的,
 * 默认采用的是service方法中的参数值,如果缓存中没有获取到,则调用目标方法进行获取数据,获取之后则再将它放到
缓存中(key=参数值,value=返回值)
 *
 * 第二次请求:
 * 5. 如果再次调用 则还是先ConcurrentMapCacheManager.getCache()获取缓存对象,如果有则直接返回,如果没有
则创建
 * 6. 然后再调用 ConcurrentMapCache.lookup方法从缓存中获取数据, 如果缓存有数据则直接响应回去,不会再去调
用目标方法,
 *
 * 第三次请求与第二次请求一样.
 * 如果缓存中没有缓存管理器,则与第一次请求一致
 *
 * 注意：如果引用了redis缓存后，则springboot会自动切换为redis缓存数据

 */
@EnableCaching//开启注解版的缓存
@MapperScan("com.yzl.springboot.mapper")
@SpringBootApplication
public class SpringBoot13CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot13CacheApplication.class, args);
    }

}
