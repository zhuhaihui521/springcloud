package com.mall.huitop.mapper;

import com.mall.huitop.entity.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhuhaihui
 * @date 2020-06-02 10:06
 */
@Mapper
public interface OrderMapper {
    @Insert("insert into seckillorder(productid,amount) values(#{productid},#{amount})")
    int save(Order order);

    @Delete("delete from seckillorder where id=#{id}")
    void deleteOrder(@Param("id") Long id);
}
