package cn.liyang.springredis.mapper;

import cn.liyang.springredis.pojo.Card;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author liyang
 * @date 2019/9/7 22:45
 * @description:
 */
@Repository
public interface CardMapper {
    @Select( "select * from card where id=#{id}" )
    Card findById (Long id);
}
