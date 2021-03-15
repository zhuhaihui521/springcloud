package com.mall.huitop.service;


import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface GoodsSearchService {

    /**
     * 解析页面
     */
     void parseContent(String Keywords) throws Exception;

    /**
     * 搜索数据
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     * @throws IOException
     */
    List<Map<String, Object>> searchPage(String keyword, int pageNo, int pageSize) throws IOException;

    /**
     * 获取的数据高亮
     * @param keyword
     * @param pageNo
     * @param pageSize
     * @return
     * @throws IOException
     */
    List<Map<String,Object>> searchPageHighlightBuilder(String keyword,int pageNo,int pageSize) throws IOException;
}
