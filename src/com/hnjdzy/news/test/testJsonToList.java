package com.hnjdzy.news.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.hnjdzy.news.dao.impl.NewsDaoImpl;
import com.hnjdzy.news.entity.News;
import com.hnjdzy.news.util.CommonUtil;

import net.sf.json.JSONArray;

public class testJsonToList {

	@Test
	public void test() throws IllegalArgumentException, IllegalAccessException {
		List<News> newsList = new NewsDaoImpl().findAllNews();
		JSONArray ja = CommonUtil.convertListToJSONArray(newsList);
		List<News> pa = JSON.parseArray(ja.toString(), News.class);
		System.out.println(pa);
	}

}
