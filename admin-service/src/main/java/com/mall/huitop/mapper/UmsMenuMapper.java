package com.mall.huitop.mapper;

import com.mall.huitop.entity.UmsMenu;
import com.mall.huitop.entity.UmsMenuExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-07-18 11:20
 */
@Mapper
public interface UmsMenuMapper {

    List<UmsMenu> selectByExample(UmsMenuExample umsMenuExample);

    /**
     * 根据主键id查询
     * @param id
     * @return
     */
    UmsMenu selectByPrimaryKey(Long id);

    int insert(UmsMenu umsMenu);
}
