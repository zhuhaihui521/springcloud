package com.mall.huitop.repository;

import com.mall.huitop.model.SerachContent;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface GoodsRepository extends ElasticsearchRepository<SerachContent, Long> {
}
