package cn.liyang.springredis.service;

import cn.liyang.springredis.pojo.Employee;

import java.util.List;

/**
 * @author liyang
 * @date 2019/9/6 15:19
 * @description:
 */
public interface EmployeeService {

    Employee findById (Long id);

    List<Employee> findAll();

    Employee update (Employee employee);

    int delete (Long id);

}
