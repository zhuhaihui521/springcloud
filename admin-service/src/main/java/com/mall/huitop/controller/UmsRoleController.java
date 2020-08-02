package com.mall.huitop.controller;

import com.mall.huitop.common.api.CommonPage;
import com.mall.huitop.common.api.CommonResult;
import com.mall.huitop.entity.UmsMenu;
import com.mall.huitop.entity.UmsRole;
import com.mall.huitop.entity.UserAdmin;
import com.mall.huitop.entity.UserResource;
import com.mall.huitop.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhuhaihui
 * @date 2020-07-17 10:19
 */
@Controller
@Api(tags = "UmsRoleController", description = "后台用户角色管理")
@RequestMapping("/role")
public class UmsRoleController {
    @Autowired
    private UmsRoleService roleService;
    @ApiOperation("获取所有角色")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsRole>> listAll() {
        List<UmsRole> roleList = roleService.listAll();
        return CommonResult.success(roleList);
    }

    @ApiOperation("根据角色名称分页获取角色列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UmsRole>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                  @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                  @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {

        List<UmsRole> adminList = roleService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(adminList));
    }
    @ApiOperation("获取角色相关菜单")
    @RequestMapping(value = "/listMenu/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsMenu>> listMenu(@PathVariable Long roleId){
        List<UmsMenu> roleList=roleService.listMenu(roleId);
        return CommonResult.success(roleList);
    }
    @ApiOperation("给角色分配菜单")
    @RequestMapping(value = "/allocMenu", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult allocResource(@RequestParam Long roleId, @RequestParam List<Long> menuIds) {
        int count = roleService.allocMenu(roleId, menuIds);
        return CommonResult.success(count);
    }

    @ApiOperation("获取角色相关资源")
    @RequestMapping(value = "/listResource/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UserResource>> listResource(@PathVariable Long roleId) {
        List<UserResource> roleList = roleService.listResource(roleId);
        return CommonResult.success(roleList);
    }
    @ApiOperation("编辑角色相关资源")
    @RequestMapping(value = "/update/{roleId}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long roleId,@RequestBody UmsRole role) {
        int count = roleService.updateByRoleId(roleId,role);
        if (count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }


}
