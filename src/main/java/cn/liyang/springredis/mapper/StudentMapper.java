package cn.liyang.springredis.mapper;

import cn.liyang.springredis.pojo.Student;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liyang
 * @date 2019/9/7 22:14
 * @description:
 */
@Repository
public interface StudentMapper {

    @Select( "select * from student where teacher_id = #{id}" )
    @Results({
            @Result(property = "card",column = "card_type",one = @One(select = ("cn.liyang.springredis.mapper.CardMapper.findById")))
    })
    List<Student> getStudentsByTeacherId (Long id);

    @Select( "select * from student where id = #{id}" )
    @Results({
            @Result(property = "card",column = "card_type",one = @One(select = ("cn.liyang.springredis.mapper.CardMapper.findById")))
    })
    Student findById (Long id);
}
