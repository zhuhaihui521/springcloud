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

    List<UmsRole> list();


}
