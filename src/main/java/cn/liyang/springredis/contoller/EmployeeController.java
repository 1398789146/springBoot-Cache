package cn.liyang.springredis.contoller;

import cn.liyang.springredis.pojo.Employee;
import cn.liyang.springredis.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liyang
 * @date 2019/9/6 15:26
 * @description:
 */
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employee/{id}")
    public Employee findById (@PathVariable("id") Long id) {
        Employee employee = employeeService.findById( id );
        return employee;
    }

    @RequestMapping("/employee/list")
    public List<Employee> findAll () {
        List<Employee> all = employeeService.findAll();
        return all;
    }

    @RequestMapping("/update/emp")
    public Employee update ( Employee employee) {
        System.out.println(employee);
        return employeeService.update( employee );
    }
    @RequestMapping("/delete/{id}")
    @ResponseBody
    public String delete (@PathVariable("id") Long id) {
        employeeService.delete( id );
        return "删除成功";
    }
}
