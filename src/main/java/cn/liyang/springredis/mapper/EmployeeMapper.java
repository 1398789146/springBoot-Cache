package cn.liyang.springredis.mapper;

import cn.liyang.springredis.pojo.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liyang
 * @date 2019/9/6 15:00
 * @description:
 */
@Repository
public interface EmployeeMapper {

    List<Employee> query (Employee employee);

    List<Employee> findByIds (List list);

    @Select("select * from employee where id=#{id}")
    Employee findById (Long id);


    @Select("select * from employee ")
    List<Employee> findAll ();


    int update (Employee employee);

    @Delete("delete from employee where id = #{id}")
    int delete (Long id);

    List<Employee> findByIdXml (Employee employee);
}
