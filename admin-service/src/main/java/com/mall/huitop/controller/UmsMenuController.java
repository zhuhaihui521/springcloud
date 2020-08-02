package com.mall.huitop.controller;

import com.mall.huitop.common.api.CommonPage;
import com.mall.huitop.common.api.CommonResult;
import com.mall.huitop.dto.UmsMenuNode;
import com.mall.huitop.entity.UmsMenu;
import com.mall.huitop.service.UmsMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-07-18 11:14
 */
@Controller
@Api(tags = "UmsMenuController", description = "后台角色菜单管理")
@RequestMapping("/menu")
public class UmsMenuController {
    @Autowired
    private UmsMenuService umsMenuService;


    @ApiOperation("根据ID获取菜单详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<UmsMenu> getItem(@PathVariable Long id){
        UmsMenu umsMenu = umsMenuService.getItemById(id);
        return CommonResult.success(umsMenu);
    }
    @ApiOperation("添加菜单")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody UmsMenu umsMenu) {
        int count = umsMenuService.create(umsMenu);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }

    @ApiOperation("树形结构返回所有菜单列表")
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsMenuNode>> treeList() {
        List<UmsMenuNode> list = umsMenuService.treeList();
        return CommonResult.success(list);
    }

    @ApiOperation("分页查询后台菜单")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsMenu>> list(@PathVariable Long parentId,
                                            @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                            @RequestParam(value = "pageNum",defaultValue = "1")Integer pagetNum) {

        List<UmsMenu> list = umsMenuService.list(parentId,pageSize,pagetNum);
        return CommonResult.success(CommonPage.restPage(list));
    }



}
