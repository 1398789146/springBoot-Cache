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
 */
@SpringBootApplication
@MapperScan("cn.liyang.springredis.mapper")
@EnableCaching
public class SpringRedisApplication {
    public static void main (String[] args) {
        SpringApplication.run( SpringRedisApplication.class, args );
    }
}
