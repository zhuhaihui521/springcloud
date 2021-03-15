package com.mall.huitop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.mall.huitop.model.SerachContent;
import com.mall.huitop.repository.GoodsRepository;
import com.mall.huitop.service.GoodsSearchService;
import com.mall.huitop.utils.HtmlParseUtil;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class GoodsSearchServiceImpl implements GoodsSearchService {
    private Logger logger=LoggerFactory.getLogger(GoodsSearchServiceImpl.class);

    @Autowired
    private GoodsRepository goodsRepository;

    /**
     * 解析页面
     * @param keywords
     * @return
     * @throws Exception
     */
    @Override
    public void parseContent(String keywords) throws Exception {
        List<SerachContent> contents = new HtmlParseUtil().serachContents(keywords);
        for (SerachContent serachContent:contents){
            if (serachContent.getTitle() != null && !"".equals(serachContent.getTitle())){
                goodsRepository.save(serachContent);
            }
        }
    }

    @Override
    public List<Map<String, Object>> searchPage(String keyword, int pageNo, int pageSize) throws IOException {
        if (pageNo <= 1){
            pageNo = 1;
        }
        //精准匹配
        MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("title", keyword);
        SearchQuery searchQuery=new NativeSearchQuery(queryBuilder);
        searchQuery.setPageable(PageRequest.of(pageNo,pageSize));
        Page<SerachContent> search = goodsRepository.search(searchQuery);
        //执行搜索
        Iterator<SerachContent> iterator = search.iterator();
        //解析结果
        ArrayList<Map<String,Object>> list = new ArrayList<>();
        while (iterator.hasNext()){
            list.add(obj2Map(iterator.next()));
        }
        return list;
    }

    @Override
    public List<Map<String, Object>> searchPageHighlightBuilder(String keyword, int pageNo, int pageSize) throws IOException {
        return null;
    }

    private  Map<String, Object> obj2Map(Object objs) {
        String json = new Gson().toJson(objs);
        Map<String, Object> maps = JSONObject.parseObject(json);
        return maps;
    }

}
