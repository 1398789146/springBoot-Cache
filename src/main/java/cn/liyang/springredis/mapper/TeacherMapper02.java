package cn.liyang.springredis.mapper;

import cn.liyang.springredis.pojo.Teacher;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liyang
 * @date 2019/9/7 21:11
 * @description:
 */
@Repository
public interface TeacherMapper02 {
    @Select( "select * from teacher" )
    @Results({
            @Result(property = "students",javaType =List.class,column = "id",many = @Many(select = "cn.liyang.springredis.mapper.StudentMapper.getStudentsByTeacherId"))
    })
    List<Teacher> findAll ();
    @Select( "select * from teacher where id=#{id}" )
    @Results({
            @Result(property = "students",javaType =List.class,column = "id",many = @Many(select = "cn.liyang.springredis.mapper.StudentMapper.getStudentsByTeacherId"))
    })
    Teacher findById (Long id);
}
