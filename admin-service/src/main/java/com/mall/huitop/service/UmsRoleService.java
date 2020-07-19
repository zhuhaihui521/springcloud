package com.mall.huitop.service;

import com.mall.huitop.entity.UmsMenu;
import com.mall.huitop.entity.UmsRole;
import com.mall.huitop.entity.UserResource;

import java.util.List;

/**
 * @author zhuhaihui
 * @date 2020-07-15 12:20
 */
public interface UmsRoleService {
    /**
     * 根据adminId查询所有可操作的菜单
     * @param adminId
     * @return
     */
    List<UmsMenu> getMenuList(Long adminId);

    /**
     * 查询所有的角色
     * @return
     */
    List<UmsRole> listAll();

    /**
     * 根据条件分页查询
     * @param keyword
     * @param pageSize
     * @param pageNum
     * @return
     */
    List<UmsRole> list(String keyword, Integer pageSize, Integer pageNum);
    /**
     * 获取角色相关菜单
     */
    List<UmsMenu> listMenu(Long roleId);

    /**
     * 给角色分配资源
     * @param roleId
     * @param resourceIds
     * @return
     */
    int allocResource(Long roleId, List<Long> resourceIds);

    /**
     * 给角色分配菜单
     * @param roleId
     * @param menuIds
     * @return
     */
    int allocMenu(Long roleId, List<Long> menuIds);

    /**
     * 根据roleId查询出所有的资源
     * @param roleId
     * @return
     */
    List<UserResource> listResource(Long roleId);
}
