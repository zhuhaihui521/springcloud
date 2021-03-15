package com.mall.huitop.controller;

import com.mall.huitop.common.api.CommonPage;
import com.mall.huitop.common.api.CommonResult;
import com.mall.huitop.dto.UserAdminDto;
import com.mall.huitop.entity.UmsRole;
import com.mall.huitop.entity.UserAdmin;
import com.mall.huitop.service.UmsAdminService;
import com.mall.huitop.service.UmsRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mall.huitop.common.api.ResultCode.ACCOUNTLOCKED;
import static com.mall.huitop.common.api.ResultCode.NOUSERADMIN;
import static com.mall.huitop.common.api.StatusType.ENABLE;


/**
 * @author zhuhaihui
 * @date 2020-07-15 12:18
 */
@Controller
@RequestMapping("admin")
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
        UserAdmin adminByUsername = adminService.getAdminByUsername(userAdminDto.getUsername());
        if (adminByUsername == null){
            return CommonResult.failed(NOUSERADMIN,NOUSERADMIN.getMessage());
        }
        if (adminByUsername.getStatus() == ENABLE.getCode()){
            return CommonResult.failed(ACCOUNTLOCKED,ACCOUNTLOCKED.getMessage());
        }
        String token = adminService.login(userAdminDto.getUsername(), userAdminDto.getPassword());
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }
    @ApiOperation(value = "刷新token")
    @RequestMapping(value = "/refreshToken", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (refreshToken == null) {
            return CommonResult.failed("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
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
        UserAdmin userAdmin = adminService.getAdminByUsername(principal.getName());
        Map<String, Object> data = new HashMap<>();
        data.put("username", userAdmin.getUsername());
        data.put("roles", new String[]{"TEST"});
        data.put("menus", roleService.getMenuList(userAdmin.getId()));
        data.put("icon", userAdmin.getIcon());
        return CommonResult.success(data);
    }
    @ApiOperation(value = "登出功能")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success(null);
    }

    @ApiOperation("获取指定用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<UserAdmin> getItem(@PathVariable Long id){
        UserAdmin admin = adminService.getItem(id);
        return CommonResult.success(admin);
    }
    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<UserAdmin>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                                   @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                   @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<UserAdmin> adminList = adminService.list(keyword, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(adminList));
    }

//    @ApiOperation("获取指定用户的角色")
//    @RequestMapping(value = "/role/{adminId}", method = RequestMethod.GET)
//    @ResponseBody
//    public CommonResult<List<UserRole>> getRoleList(@PathVariable Long adminId) {
//        List<UmsRole> roleList = adminService.getRoleList(adminId);
//        return CommonResult.success(roleList);
//    }
    @ApiOperation("修改指定用户信息")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable Long id, @RequestBody UserAdmin admin) {
        int count=adminService.update(id,admin);
        if (count > 0){
            return CommonResult.success(count);
        }
        return  CommonResult.failed();
    }
    @ApiOperation("修改帐号状态")
    @RequestMapping(value = "/updateStatus/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStatus(@PathVariable Long id,@RequestParam(value = "status") Integer status) {
        UserAdmin umsAdmin = new UserAdmin();
        umsAdmin.setStatus(status);
        int count = adminService.update(id,umsAdmin);
        if (count > 0){
            return CommonResult.success(count);
        }
        return  CommonResult.failed();
    }

    @ApiOperation("分配角色")
    @RequestMapping(value = "/role/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsRole>> getRoleList(@PathVariable Long adminId){
        List<UmsRole> roleList = adminService.getRoleList(adminId);
        return CommonResult.success(roleList);
    }
    @ApiOperation("更新角色")
    @RequestMapping(value = "/role/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRole(@RequestParam("adminId") Long adminId,
                                   @RequestParam("roleIds") List<Long> roleIds){
        int count = adminService.updateRole(adminId, roleIds);
        if (count >= 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
    @ApiOperation("删除用户")
    @RequestMapping(value = "/delete/{adminId}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable Long adminId){
        //在删除用户表的时候，也应该删除和用户表相关联的所有表以及缓存。
        int count=adminService.delete(adminId);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
