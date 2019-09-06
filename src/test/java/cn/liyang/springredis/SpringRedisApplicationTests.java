package cn.liyang.springredis;

import cn.liyang.springredis.mapper.EmployeeMapper;
import cn.liyang.springredis.pojo.Employee;
import cn.liyang.springredis.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRedisApplicationTests {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeMapper employeeMapper;
    @Test
    public void contextLoads () {
        System.out.println( employeeService.findById( 1L ) );
    }
    @Test
    public void update () {
        Employee employee = new Employee();
        employee.setYuangongname( "liyang" );
        employee.setId( 1L );
        int update = employeeMapper.update( employee );
        System.out.println(update);
    }

}
