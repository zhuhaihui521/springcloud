package com.mall.huitop.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "jd_goods",type = "serachContent",shards = 1,replicas = 0)
public class SerachContent implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    private Long id;
    @Field(analyzer = "ik_max_word",type = FieldType.Keyword)
    private String title;
    @Field(type = FieldType.Keyword)
    private String img;
    @Field(type = FieldType.Keyword)
    private String price;
    @Field(analyzer = "ik_max_word",type = FieldType.Keyword)
    private String shop;

}
