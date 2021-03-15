package com.mall.huitop;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.mall.huitop.model.SerachContent;
import com.mall.huitop.repository.GoodsRepository;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.collapse.CollapseBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.facet.FacetRequest;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.elasticsearch.index.mapper.AllFieldMapper.Defaults.INDEX_NAME;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.search.aggregations.metrics.percentiles.PercentileRanks.TYPE_NAME;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SerachSpringBoot.class})// 指定启动类
@Slf4j
public class EStest {
    @Autowired
    private GoodsRepository goodsRepository;


    @Test
    public void testQuery(){
        QueryBuilder queryBuilder= QueryBuilders.termQuery("title", "vue");
        SearchQuery searchQuery=new NativeSearchQuery(queryBuilder);
        searchQuery.setPageable(PageRequest.of(1,5));
        Page<SerachContent> search = goodsRepository.search(searchQuery);
        //执行搜索
        Iterator<SerachContent> iterator = search.iterator();
        //解析结果
        ArrayList<Map<String,Object>> list = new ArrayList<>();
        while (iterator.hasNext()){
            list.add(obj2Map(iterator.next()));
        }
        System.out.println(JSON.toJSONString(list));
    }
    private  Map<String, Object> obj2Map(Object objs) {
        String json = new Gson().toJson(objs);
        Map<String, Object> maps = JSONObject.parseObject(json);
        return maps;
    }


}
