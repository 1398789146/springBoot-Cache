package cn.liyang.springredis;

import cn.liyang.springredis.mapper.*;
import cn.liyang.springredis.pojo.*;
import cn.liyang.springredis.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRedisApplicationTests {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper02 teacherMapper02;
    @Autowired
    CardMapper cardMapper;
    @Autowired
    OrderMapper orderMapper;
    @Test
    public void testOrder(){
        Order order = orderMapper.findById( 1L );
        System.out.println(order);
    }
    @Test
    public void testCard(){
        Card card = cardMapper.findById( 1L );
        System.out.println(card);
    }
    @Test
    public void testTeacher02(){
//        Teacher teacher = teacherMapper02.findById( 1L );
//        List<Student> students = teacher.getStudents();
        List<Teacher> teachers = teacherMapper02.findAll();
        List<Student> students = teachers.get( 1 ).getStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
    @Test
    public void testStudent(){
        Student s = studentMapper.findById( 1L );
        System.out.println(s);
    }
    @Test
    public void testTeacher(){
        List<Teacher> all = teacherMapper.findAll();
        List<Student> students = all.get( 0 ).getStudents();
//        Teacher teacher = teacherMapper.findById( 1L );
//        List<Student> students = teacher.getStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
    @Test
    public void contextLoads () {
        System.out.println( employeeService.findById( 1L ) );
    }
    @Test
    public void update () {
        Employee employee = new Employee();
        employee.setYuangongname( "老王" );
        employee.setWord( "总经理" );
        employee.setId( 2L );
        int update = employeeMapper.update( employee );
        System.out.println(update);
    }

    @Test
    public void testXMl(){
        Employee employee = new Employee();
        employee.setWord( "职" );
        System.out.println(employee);
        List<Employee> list = employeeMapper.findByIdXml( employee );
        for (Employee employee1 : list) {
            System.out.println(employee1);
        }
    }

    @Test
    public void query(){
        Employee employee = new Employee();
       // employee.setId( 2 );
        //employee.setYuangongname( "老王" );
        employee.setWord( "职员" );
        List<Employee> query = employeeMapper.query( employee );
        for (Employee employee1 : query) {
            System.out.println(employee1);
        }
    }

    @Test
    public void findByIds(){
        List<Integer> list = new ArrayList<>( Arrays.asList( 1,2,3,4 ) );
        List<Employee> employees = employeeMapper.findByIds( list );
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

}
