package com.mall.huitop.service;

import com.mall.huitop.entity.UmsMenu;
import com.mall.huitop.entity.UmsRole;

import java.util.List;

/**
 * @author zhuhaihui
 * @date 2020-07-15 12:20
 */
public interface UmsRoleService {
    List<UmsMenu> getMenuList(Long adminId);

    List<UmsRole> listAll();

    /**
     * 根据条件分页查询
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum);
}
