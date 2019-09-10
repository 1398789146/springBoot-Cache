package cn.liyang.springredis;

import cn.liyang.springredis.mapper.EmployeeMapper;
import cn.liyang.springredis.mapper.OrderMapper;
import cn.liyang.springredis.pojo.Employee;
import cn.liyang.springredis.pojo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author liyang
 * @date 2019/9/9 9:57
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedis {
    @Autowired
    StringRedisTemplate stringRedisTemplate;//k-v字符串
    @Autowired
    RedisTemplate redisTemplate;//k-v 对象
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    RedisTemplate<Object, Employee> empRedisTemplate;
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * Redis的常用5大数据类型
     * String(字符串) List(列表) set(集合) hash(散列) ZSet(有序集合)
     * String(字符串)     :   stringRedisTemplate.opsForValue();
     * List(列表)         :   stringRedisTemplate.opsForList();
     * set(集合)          :   stringRedisTemplate.opsForSet();
     * hash(散列)         :   stringRedisTemplate.opsForHash();
     * ZSet(有序集合)      :   stringRedisTemplate.opsForZSet();
     */
    //字符串类型的保存
    @Test
    public void test01(){
       // stringRedisTemplate.opsForValue().append( "msg","china" );
        //String msg = stringRedisTemplate.opsForValue().get( "msg" );
        stringRedisTemplate.opsForList().leftPush( "mylist", "1" );
        stringRedisTemplate.opsForList().leftPush( "mylist", "2" );
        stringRedisTemplate.opsForList().leftPush( "mylist", "3" );
        stringRedisTemplate.opsForList().leftPush( "mylist", "4" );
    }
    //对象类型保存
    @Test
    public void test02(){
        //用jdk默认的进制序列化器
        redisTemplate.opsForSet().add( "mySet",orderMapper.findById( 1L ) );
        //用json序列化对象
        empRedisTemplate.opsForSet().add( "mySet01",employeeMapper.findById( 1L ) );
    }


    @Test
    public void testOrder(){
        Order order = orderMapper.findById( 1L );
        System.out.println(order);
    }
}
