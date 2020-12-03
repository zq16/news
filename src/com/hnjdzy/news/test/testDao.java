package com.hnjdzy.news.test;

import static org.junit.Assert.*;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.hnjdzy.news.dao.impl.NewsDaoImpl;
import com.hnjdzy.news.entity.News;
import com.hnjdzy.news.util.CommonUtil;
import com.hnjdzy.news.util.DatabaseUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class testDao {

	@Test
	public void test() throws IllegalArgumentException, IllegalAccessException {
		NewsDaoImpl ndi = new NewsDaoImpl();

		try {
			System.out.println(ndi.findNewsByCondition("重"));
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

	}
	

}
