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

    @Select("select * from employee where id=#{id}")
    Employee findById (Long id);

    @Select("select * from employee ")
    List<Employee> findAll();

    @Update( "update employee set  yuangongname=#{yuangongname},word=#{word},lineManagerId=#{lineManagerId}," +
            "entryTime=#{entryTime},wage=#{wage},bonus=#{bonus},word=#{bumenTableId},word=#{bumenTableId} where id=#{id}  " )
    int update (Employee employee);

    @Delete( "delete from employee where id = #{id}" )
    int delete (Long id);


}
