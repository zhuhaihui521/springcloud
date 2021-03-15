package com.mall.huitop.mapper;


import com.mall.huitop.entity.TradeMqConsumerLog;
import com.mall.huitop.entity.TradeMqConsumerLogExample;
import com.mall.huitop.entity.TradeMqConsumerLogKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface MqConsumerLogMapper {
    int countByExample(TradeMqConsumerLogExample example);

    int deleteByExample(TradeMqConsumerLogExample example);

    int deleteByPrimaryKey(TradeMqConsumerLogKey key);

    int insert(TradeMqConsumerLog record);

    int insertSelective(TradeMqConsumerLog record);

    List<TradeMqConsumerLog> selectByExample(TradeMqConsumerLogExample example);

    TradeMqConsumerLog selectByPrimaryKey(TradeMqConsumerLogKey key);

    int updateByExampleSelective(@Param("record") TradeMqConsumerLog record, @Param("example") TradeMqConsumerLogExample example);

    int updateByExample(@Param("record") TradeMqConsumerLog record, @Param("example") TradeMqConsumerLogExample example);

    int updateByPrimaryKeySelective(TradeMqConsumerLog record);

    int updateByPrimaryKey(TradeMqConsumerLog record);
}
