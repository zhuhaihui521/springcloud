package com.mall.huitop.security.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author zhuhaihui
 * @date 2019-08-08 11:25
 */
public class JsonUtil {


    public static String buildObjToJsonStr(Object o) {
        String json = JSON.toJSONString(o, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
        return json;
    }

    public static <T> T buildJsonStrToObj(String text, Class<T> clazz) {
        T t = JSON.parseObject(text, clazz);
        return t;
    }


}
