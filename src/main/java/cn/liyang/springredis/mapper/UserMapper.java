package cn.liyang.springredis.mapper;

import cn.liyang.springredis.pojo.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentMap;

/**
 * @author liyang
 * @date 2019/9/8 11:34
 * @description:
 */
@Repository
public interface UserMapper {
    @Select( "select * from user where id=#{id}" )
    User findById (Long id);
}
