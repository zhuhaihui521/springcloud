package com.mall.huitop.service.impl;

import com.github.pagehelper.PageHelper;
import com.mall.huitop.cache.UserAdminCacheService;
import com.mall.huitop.entity.*;
import com.mall.huitop.mapper.UmsRoleMapper;
import com.mall.huitop.mapper.UmsRoleMenuRelationMapper;
import com.mall.huitop.mapper.UmsRoleResourceRelationMapper;
import com.mall.huitop.service.UmsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author zhuhaihui
 * @date 2020-07-15 12:20
 */
@Service
public class UmsRoleServiceImpl implements UmsRoleService {

    @Autowired(required = false)
    private UmsRoleMapper umsRoleMapper;
    @Autowired(required = false)
    private UmsRoleMenuRelationMapper roleMenuRelationMapper;
    @Autowired(required = false)
    private UmsRoleResourceRelationMapper roleResourceRelationMapper;

    @Autowired
    private UserAdminCacheService adminCacheService;

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

    @Override
    public List<UmsMenu> listMenu(Long roleId) {
        return umsRoleMapper.getMenuListByRoleId(roleId);
    }


    /**
     * 分配资源时删除原有的
     * @param roleId
     * @param resourceIds
     * @return
     */
    @Override
    @Transactional
    public int allocResource(Long roleId, List<Long> resourceIds) {
        //先删除原有关系
        UmsRoleResourceRelationExample example=new UmsRoleResourceRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleResourceRelationMapper.deleteByExample(example);
        //批量插入新关系
        for (Long resourceId : resourceIds) {
            UmsRoleResourceRelation relation = new UmsRoleResourceRelation();
            relation.setRoleId(roleId);
            relation.setResourceId(resourceId);
            roleResourceRelationMapper.insert(relation);
        }
        adminCacheService.delResourceListByRole(roleId);
        return resourceIds.size();
    }

    /**
     * 给角色分配菜单
     * @param roleId
     * @param menuIds
     * @return
     */
    @Override
    public int allocMenu(Long roleId, List<Long> menuIds) {
        //先删除原有关系
        UmsRoleMenuRelationExample example=new UmsRoleMenuRelationExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        roleMenuRelationMapper.deleteByExample(example);
        //批量插入新关系
        for (Long menuId : menuIds) {
            UmsRoleMenuRelation relation = new UmsRoleMenuRelation();
            relation.setRoleId(roleId);
            relation.setMenuId(menuId);
            roleMenuRelationMapper.insert(relation);
        }
        return menuIds.size();
    }

    @Override
    public List<UserResource> listResource(Long roleId) {

        return umsRoleMapper.getResourceListByRoleId(roleId);

    }
}
