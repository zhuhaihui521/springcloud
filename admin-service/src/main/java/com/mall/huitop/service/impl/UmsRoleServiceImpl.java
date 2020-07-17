package com.mall.huitop.service.impl;

import com.github.pagehelper.PageHelper;
import com.mall.huitop.entity.UmsMenu;
import com.mall.huitop.entity.UmsRole;
import com.mall.huitop.entity.UmsRoleExample;
import com.mall.huitop.mapper.UmsRoleMapper;
import com.mall.huitop.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public List<UmsRole> listAll() {
        return umsRoleMapper.listAll();
    }

    @Override
    public List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UmsRoleExample umsRoleExample=new UmsRoleExample();
        if (!StringUtils.isEmpty(keyword)) {
            umsRoleExample.createCriteria().andNameLike("%" + keyword + "%");
        }
        return umsRoleMapper.selectByExample(umsRoleExample);
    }
}
