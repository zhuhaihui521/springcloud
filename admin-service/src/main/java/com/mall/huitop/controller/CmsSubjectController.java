package com.mall.huitop.controller;

import com.mall.huitop.common.api.CommonResult;
import com.mall.huitop.entity.CmsSubject;
import com.mall.huitop.service.CmsSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-02 20:15
 */
@RestController
@Api(tags = "CmsSubjectController", description = "商品专题管理")
@RequestMapping("/subject")
public class CmsSubjectController {

    @Autowired
    private CmsSubjectService cmsSubjectService;

    @ApiOperation("获取全部商品专题")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public CommonResult<List<CmsSubject>> listAll() {
        List<CmsSubject> subjectList = cmsSubjectService.listAll();
        return CommonResult.success(subjectList);
    }



}
