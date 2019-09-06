package cn.liyang.springredis.service.impl;

import cn.liyang.springredis.mapper.EmployeeMapper;
import cn.liyang.springredis.pojo.Employee;
import cn.liyang.springredis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liyang
 * @date 2019/9/6 15:21
 * @description:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 将方法的运行结果进行缓存;以后再取相同的数据,直接从缓存中取,不用再掉方法;
     * CacheManager 缓存管理器,来管理缓存,缓存数据crud还是再Cache中进行,每个缓存有自己唯一的名字;
     * Cache的几个属性:
     *   1. cacheNames=""   :   指定缓存的名字,可以指定多个缓存测名字,将值缓存在多个缓存中
     *   2. key=""          :   缓存数据指定的key,默认用参数名字 多个参数可以用 #root.args[0]/#p0 来指定哪一个
     *          key/keyGenerator:两个属性二选一
     *          key的默认生成策略是:SimpleKeyGenerator生成;
     *              如果没有参数: key = new SimpleKey();
     *              如果有一个参数: key = 参数的值;
     *              如果有多个参数: key = new SimpleKey(params);
     *   3. cacheManager="" :   指定缓存管理器
     *   4. condition=""    :   指定缓存的条件,比如id>3才会缓存
     *   5. unless=""       :   当unless的条件为true时,不会执行缓存,unless = "#result == null "(当方法结果为null不缓存)
     *原理:
     *  1. 自动配置类;CacheAutoConfiguration
     *  2. 缓存的配置类有9个
     *  3. 默认生效配置类:SimpleCacheConfiguration
     *  4. 给容器注册一个缓存管理器CacheManager: ConcurrentMapCacheManager;
     *  5. 可以获取和创建ConcurrentMapCache类型的缓存组件;该组件的作用将数据保存在ConcurrentMap容器中;
     *        1. 能根据缓存对象的名字获得缓存对象,这个键值对,存放在ConcurrentMap集合中
     *        2. 如果名字不存在,就会创建一个
     * 运行流程:
     *  1. 业务方法运行之前,先获取方法上cacheNames的缓存对象的名字,先去查询Cache是否存在,
     *     第一次没有cache,缓存管理器CacheManager会先创建一个缓存对象;
     *  2. 取缓存cache中,根据key(默认方法参数名)获得数据;
     *  3. 如果没有查到缓存就调用目标方法
     *  4. 将目标方法结果放进缓存中 put进concurrentMap<K 方法参数,V 方法的返回值(这里的emp对象)>
     *核心:
     *      1. 使用CacheManager(如果没有配置默认:ConcurrentMapCacheManager)按照名字获得Cache(ConcurrentMapCache)组件
     *      2. key使用keyGenerator生成的,默认使用SimpleKeyGenerator
     * @param id
     * @return
     */
    @Override
    @Cacheable(cacheNames = "emp",key = "#p0"/*keyGenerator = "myKeyGenerator",condition = "#root.args[0]>3"*/,unless = "#result == null ")
    public Employee findById (Long id) {
        System.out.println("根据"+id+"查询一个员工");
        return employeeMapper.findById( id );
    }

    @Override
    public List<Employee> findAll () {
        System.out.println("查询所有employee");
        return employeeMapper.findAll();
    }

    /**
     *  @CachePut注解的作用: 更新数据库,同步更新缓存
     *      1. 即调用目标方法,又把结果放进cache缓存里
     *      2. 放进缓存里的key要与,查询该对象的key一样
     *      3. 放与取的key一样这样更新后放入缓存里的数据才能,覆盖掉原先该key的值(跟新与查询用的key一定要一样)
     *      4. 覆盖掉原先内存里的值,才能保证从缓存里查出的结果准确性
     *
     * @param employee
     * @return
     */
    @Override
    @CachePut(cacheNames = "emp",key = "#employee.id"/*key = "#result.id"*/)
    public Employee update (Employee employee) {
        employeeMapper.update( employee );
        return employee;
    }

    /**
     *  @CacheEvict注解:
     *      1. 删除数据库数据的同时,根据设置的缓存key,删除对应缓存中的值
     *      2. 保证数据库删除后,从缓存中也是被删除的,保证查询的准确性
     *      beforeInvocation = true: 该属性设置是否在执行方法之前清除缓存
     *      true:当执行方法出错时,缓存已经查不到删除的对象了
     *      false: 当方法出错时,还能从缓存中查询出要删除的对象
     *  allEntries = true:作用
     *      当执行这个目标方法时会删除掉所有缓存
     * @param id
     * @return
     */
    @Override
    @CacheEvict(cacheNames = "emp"/*,key = "#id"*/,beforeInvocation = true/*allEntries = true*/)
    public int delete (Long id) {
        System.out.println("删除id="+id+"的员工");
        //int affectRows = employeeMapper.delete( id );
        return 1/0;
    }
}
