package com.mall.huitop.controller;

import com.mall.huitop.common.api.CommonPage;
import com.mall.huitop.common.api.CommonResult;
import com.mall.huitop.dto.PmsProductParam;
import com.mall.huitop.dto.PmsProductQueryParam;
import com.mall.huitop.dto.PmsProductResult;
import com.mall.huitop.entity.PmsProduct;
import com.mall.huitop.service.PmsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther zhuhaihui
 * @Date 2020-08-02 19:04
 */
@RestController
@Api(tags = "PmsProductController", description = "商品管理")
@RequestMapping("/product")
public class PmsProductController {
    @Autowired
    private PmsProductService productService;

    @ApiOperation("查询商品")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public CommonResult<CommonPage<PmsProduct>> getList(PmsProductQueryParam productQueryParam,
                                                        @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsProduct> productList = productService.list(productQueryParam, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(productList));
    }

    @ApiOperation("批量上下架")
    @RequestMapping(value = "/update/publishStatus",method = RequestMethod.POST)
    public CommonResult updatePublishStatus(@RequestParam("ids") List<Long> ids,
                                            @RequestParam("publishStatus") Integer publishStatus) {
        int count=productService.updatePublishStatus(ids, publishStatus);
        if (count >0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("新品")
    @RequestMapping(value = "/update/newStatus",method = RequestMethod.POST)
    public CommonResult updateNewStatus(@RequestParam("ids") List<Long> ids,
                                            @RequestParam("newStatus") Integer newStatus) {
        int count=productService.updateNewStatus(ids, newStatus);
        if (count >0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("推荐商品")
    @RequestMapping(value = "/update/recommendStatus",method = RequestMethod.POST)
    public CommonResult updateRecommendStatus(@RequestParam("ids") List<Long> ids,
                                        @RequestParam("recommendStatus") Integer recommendStatus) {
        int count=productService.updateRecommendStatus(ids, recommendStatus);
        if (count >0){
            return CommonResult.success(count);
        }else {
            return CommonResult.failed();
        }
    }
    @ApiOperation("根据商品id获取商品编辑信息")
    @RequestMapping(value = "/updateInfo/{id}", method = RequestMethod.GET)
    public CommonResult<PmsProductResult> getUpdateInfo(@PathVariable Long id) {
        PmsProductResult productResult = productService.getUpdateInfo(id);
        return CommonResult.success(productResult);
    }

    @ApiOperation("更新商品")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public CommonResult update(@PathVariable Long id, @RequestBody PmsProductParam productParam, BindingResult bindingResult) {
        int count = productService.update(id, productParam);
        if (count > 0) {
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
