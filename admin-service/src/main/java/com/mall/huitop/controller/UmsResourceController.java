package com.mall.huitop.controller;

import com.mall.huitop.common.api.CommonPage;
import com.mall.huitop.common.api.CommonResult;
import com.mall.huitop.entity.UmsMenu;
import com.mall.huitop.entity.UserResource;
import com.mall.huitop.security.handle.DynamicSecurityMetadataSource;
import com.mall.huitop.service.UmsResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-07-19 23:00
 */
@Controller
@Api(tags = "UmsResourceController", description = "后台资源管理")
@RequestMapping("/resource")
public class UmsResourceController {
    @Autowired
    private UmsResourceService resourceService;
    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;
    @ApiOperation("查询所有后台资源")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UserResource>> listAll() {
        List<UserResource> resourceList = resourceService.listAll();
        return CommonResult.success(resourceList);
    }

    @ApiOperation("分页模糊查询后台资源")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UserResource>> list(@RequestParam(required = false) Long categoryId,
                                                       @RequestParam(required = false) String nameKeyword,
                                                       @RequestParam(required = false) String urlKeyword,
                                                  @RequestParam(value = "pageSize",defaultValue = "5")Integer pageSize,
                                                  @RequestParam(value = "pageNum",defaultValue = "1")Integer pageNum) {

        List<UserResource> list = resourceService.list(categoryId,nameKeyword, urlKeyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }
}
