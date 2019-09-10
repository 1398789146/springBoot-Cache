package cn.liyang.springredis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 *  一. 快速体验注解
 *      步骤:
 *          1. 开启基于注解的缓存@EnableCacheing
 *          2. 标注缓存注解即可
 *              @Cacheable 方法执行后结果放进缓存
 *              @CaCheEvict 方法执行删除数据后,同时删除缓存中的数据
 *              @CachePut   方法执行添加数据后,同时将数据放进缓存中
 * 默认使用ConcurrentMapCacheManager缓存管理器;将数据保存在ConcurrentMap<Object,Object>中
 * 开发中使用的缓存技术有:redis,memcache,ehcache
 *  二. 整合redis作为缓存
 *      1. 安装redis
 *      2. 引入spring-boot-starter-data-redis
 *      3. 配置redis
 *      4. 测试
 *          1. 当引入redis starter后,容器中会创建RedisCacheManager换存管理器
 *          2. 如果创建RedisCacheManager,ConcurrentMapCacheManager缓存管理器不会再创建
 *          3. 然后RedisCacheManager,创建RedisCache缓存管理组件
 *          4. RedisCache组件操作Redis缓存数据
 *      5.
 *
 */
@SpringBootApplication
@MapperScan("cn.liyang.springredis.mapper")
@EnableCaching
public class SpringRedisApplication {
    public static void main (String[] args) {
        SpringApplication.run( SpringRedisApplication.class, args );
    }
}
