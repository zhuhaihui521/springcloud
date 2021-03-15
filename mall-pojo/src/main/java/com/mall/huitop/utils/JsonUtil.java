package com.mall.huitop.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;


/**
 * json 简单操作的工具类
 * @author lee.li
 *
 */
public class JsonUtil{

	public static String buildObjToJsonStr(Object o) {
		String json = JSON.toJSONString(o, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
		return json;
	}

	public static <T> T buildJsonStrToObj(String text, Class<T> clazz) {
		T t = JSON.parseObject(text, clazz);
		return t;
	}
}