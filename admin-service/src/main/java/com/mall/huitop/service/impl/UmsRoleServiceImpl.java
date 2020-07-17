package com.mall.huitop.service.impl;

import com.mall.huitop.entity.UmsMenu;
import com.mall.huitop.entity.UmsRole;
import com.mall.huitop.mapper.UmsRoleMapper;
import com.mall.huitop.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhuhaihui
 * @date 2020-07-15 12:20
 */
@Service
public class UmsRoleServiceImpl implements UmsRoleService {
    @Autowired
    private UmsRoleMapper umsRoleMapper;
    @Override
    public List<UmsMenu> getMenuList(Long adminId) {
        return umsRoleMapper.getMenuList(adminId);
    }

    @Override
    public List<UmsRole> list() {
        return umsRoleMapper.list();
    }
}
