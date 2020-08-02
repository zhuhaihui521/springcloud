package com.mall.huitop.service;

import com.mall.huitop.dto.UmsMenuNode;
import com.mall.huitop.entity.UmsMenu;

import java.util.List;




public interface UmsMenuService {
    List<UmsMenuNode> treeList();

    /**
     * 分页查询后台菜单
     * @param parentId
     * @param pageSize
     * @param pagetNum
     * @return
     */
    List<UmsMenu> list(Long parentId, Integer pageSize, Integer pagetNum);

    /**
     * 根据id查询菜单详情
     * @param id
     * @return
     */
    UmsMenu getItemById(Long id);

    /**
     * 添加菜单
     * @param umsMenu
     * @return
     */
    int create(UmsMenu umsMenu);
}
