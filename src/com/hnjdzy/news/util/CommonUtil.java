package com.hnjdzy.news.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class CommonUtil {
	/** 实体类转JSON对象 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException */
	public static JSONObject convertBeanToJSONObject(Object obj) throws IllegalArgumentException, IllegalAccessException {
		//获取class对象
		Class<? extends Object> cls = obj.getClass();
		//获取属性列表
		Field[] fields = cls.getDeclaredFields();
		//设置安全性
		Field.setAccessible(fields, true);
		JSONObject jo = new JSONObject();
		//遍历属性列表
		for(Field f:fields) {
			//判断属性是否为空或者是常量
			if(f.get(obj) != null && !Modifier.isFinal(f.getModifiers())) {
				jo.put(f.getName(), f.get(obj).toString());
			}
		}
		return jo;
	}
	
	/** list集合转JSONArray对象 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException */
	public static JSONArray convertListToJSONArray(List list) throws IllegalArgumentException, IllegalAccessException {
		JSONArray ja = new JSONArray();
		for(Object o:list) {
			ja.add(convertBeanToJSONObject(o));
		}
		return ja;
	}
}
