package com.mall.huitop.controller;

import com.mall.huitop.common.api.CommonResult;
import com.mall.huitop.dto.UserAdminDto;
import com.mall.huitop.entity.UserAdmin;
import com.mall.huitop.service.UmsAdminService;
import com.mall.huitop.service.UmsRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


/**
 * @author zhuhaihui
 * @date 2020-07-15 12:18
 */
@Controller
@RequestMapping("admin")
public class UserAdminConroller {
    @Autowired
    private UmsAdminService adminService;
    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UserAdmin> register(@RequestBody @Valid UserAdminDto userAdminDto, BindingResult result) {
        if (result.hasErrors()){
            return CommonResult.failed(result.getFieldError().getDefaultMessage());
        }
        UserAdmin userAdmin = adminService.register(userAdminDto);
        if (userAdmin == null) {
            CommonResult.failed();
        }
        return CommonResult.success(userAdmin);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UserAdminDto userAdminDto, BindingResult result) {
        //return adminService.login(userAdminDto.getUsername(),userAdminDto.getPassword());
        return null;
    }


}
