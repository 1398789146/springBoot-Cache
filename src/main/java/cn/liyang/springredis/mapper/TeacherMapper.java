package cn.liyang.springredis.mapper;

import cn.liyang.springredis.pojo.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liyang
 * @date 2019/9/7 21:11
 * @description:
 */
@Repository
public interface TeacherMapper {
    List<Teacher> findAll( );
    Teacher findById (Long id);
}
