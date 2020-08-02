package com.mall.huitop.service.impl;

import com.github.pagehelper.PageHelper;
import com.mall.huitop.dto.UmsMenuNode;
import com.mall.huitop.entity.UmsMenu;
import com.mall.huitop.entity.UmsMenuExample;
import com.mall.huitop.mapper.UmsMenuMapper;
import com.mall.huitop.service.UmsMenuService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther zhuhaihui
 * @Date 2020-07-18 11:19
 */
@Service
public class UmsMenuServiceImpl implements UmsMenuService {
    @Autowired(required = false)
    private UmsMenuMapper umsMenuMapper;

    @Override
    public List<UmsMenuNode> treeList() {
        List<UmsMenu> menuList = umsMenuMapper.selectByExample(new UmsMenuExample());
        List<UmsMenuNode> result = menuList.stream()
                .filter(menu -> menu.getParentId().equals(0L))
                .map(menu -> covertMenuNode(menu, menuList)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<UmsMenu> list(Long parentId, Integer pageSize, Integer pageNum) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        UmsMenuExample example=new UmsMenuExample();
        example.setOrderByClause("sort desc");
        example.createCriteria().andParentIdEqualTo(parentId);
        return umsMenuMapper.selectByExample(example);
    }

    @Override
    public UmsMenu getItemById(Long id) {
        return umsMenuMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(UmsMenu umsMenu) {
        umsMenu.setCreateTime(new Date());
        //设置菜单层级，是否有父节点；
        updateLevel(umsMenu);
        return umsMenuMapper.insert(umsMenu);
    }

    private void updateLevel(UmsMenu umsMenu) {
        if (umsMenu.getParentId() == 0){
            //没有父菜单时为一级菜单
            umsMenu.setLevel(0);
        }else {
            //有父菜单时选择根据父菜单level设置
            UmsMenu parentMenu = umsMenuMapper.selectByPrimaryKey(umsMenu.getParentId());
            if (parentMenu != null){
                umsMenu.setLevel(parentMenu.getLevel() + 1);
            }else {
                umsMenu.setLevel(0);
            }
        }
    }

    /**
     * 将menu 转化为umsMenuNode并设置children属性
     * @param menu
     * @param menuList
     * @return
     */
    private UmsMenuNode covertMenuNode(UmsMenu menu, List<UmsMenu> menuList) {
        UmsMenuNode umsMenuNode =new UmsMenuNode();
        BeanUtils.copyProperties(menu,umsMenuNode);
        List<UmsMenuNode> collect = menuList.stream()
                .filter(subMenu -> subMenu.getParentId().equals(menu.getId()))
                .map(subMenu -> covertMenuNode(subMenu, menuList)).collect(Collectors.toList());

        umsMenuNode.setChildren(collect);
        return umsMenuNode;
    }
}
