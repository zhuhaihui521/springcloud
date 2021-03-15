package com.mall.huitop.controller;


import com.mall.huitop.service.GoodsSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GoodsSearchController {
   @Autowired
    private GoodsSearchService goodsSearchService;

    @GetMapping("/parse/{keyword}")
    public void parse(@PathVariable("keyword")String keyword) throws Exception {
         goodsSearchService.parseContent(keyword);
    }

    @GetMapping("/search/{keyword}/{pageNo}/{pageSize}")
    public List<Map<String, Object>> search(@PathVariable ("keyword")String keyword,
                                           @PathVariable ("pageNo")int pageNo,
                                           @PathVariable("pageSize") int pageSize) throws Exception {
        return goodsSearchService.searchPage(keyword,pageNo,pageSize);
    }

}
