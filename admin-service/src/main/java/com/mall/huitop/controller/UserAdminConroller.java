package com.mall.huitop.controller;

import com.mall.huitop.common.api.CommonResult;
import com.mall.huitop.dto.UserAdminDto;
import com.mall.huitop.entity.UserAdmin;
import com.mall.huitop.service.UmsAdminService;
import com.mall.huitop.service.UmsRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;


/**
 * @author zhuhaihui
 * @date 2020-07-15 12:18
 */
@Controller
@RequestMapping("admin")
@RefreshScope
public class UserAdminConroller {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private UmsRoleService roleService;
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

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody @Valid UserAdminDto userAdminDto, BindingResult result) {
        if (result.hasErrors()){
            return CommonResult.failed(result.getFieldError().getDefaultMessage());
        }
        String token = adminService.login(userAdminDto.getUsername(), userAdminDto.getPassword());
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
    @ApiOperation(value = "获取当前登录用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAdminInfo(Principal principal){
        if (principal == null){
            return CommonResult.unauthorized(null);
        }
        String username = principal.getName();
        UserAdmin userAdmin = adminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", userAdmin.getUsername());
        data.put("roles", new String[]{"TEST"});
        data.put("menus", roleService.getMenuList(userAdmin.getId()));
        data.put("icon", userAdmin.getIcon());
        return CommonResult.success(data);
    }

}
