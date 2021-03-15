package com.mall.huitop.utils;


import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;

/**
 * json 简单操作的工具类
 * @author lee.li
 *
 */
public class JsonUtil{
	private final static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	private final static Log log = LogFactory.getLog(JsonUtil.class);

	public static String buildObjToJsonStr(Object o) {
		String json = JSON.toJSONString(o, SerializerFeature.WriteMapNullValue, SerializerFeature.DisableCircularReferenceDetect);
		return json;
	}

	public static <T> T buildJsonStrToObj(String text, Class<T> clazz) {
		T t = JSON.parseObject(text, clazz);
		return t;
	}
}