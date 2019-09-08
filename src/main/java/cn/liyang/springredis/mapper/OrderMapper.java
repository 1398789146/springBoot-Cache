package cn.liyang.springredis.mapper;

import cn.liyang.springredis.pojo.Order;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author liyang
 * @date 2019/9/8 10:52
 * @description:
 */
@Repository
public interface OrderMapper {
    @Select( "select * from company.order where id=#{id}" )
    @Results({
            @Result(property = "user" , column = "user_id",one = @One(select = "cn.liyang.springredis.mapper.UserMapper.findById"))
    })
    Order findById (Long id);
}
