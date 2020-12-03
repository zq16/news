package com.hnjdzy.news.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;

public class testDruid {

	@Test
	public void test() throws SQLException {
		DruidDataSource dds = new DruidDataSource();
		dds.setUrl("jdbc:mysql://127.0.0.1:3306/newsmanagersystem?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC");
		dds.setDriverClassName("com.mysql.cj.jdbc.Driver"); //这个可以缺省的，会根据url自动识别
        dds.setUsername("root");
        dds.setPassword("123456");
        dds.setInitialSize(10);  //初始连接数，默认0
        dds.setMaxActive(30);  //最大连接数，默认8
        dds.setMinIdle(10);  //最小闲置数
        dds.setMaxWait(2000);  //获取连接的最大等待时间，单位毫秒
        dds.setPoolPreparedStatements(true); //缓存PreparedStatement，默认false
        dds.setMaxOpenPreparedStatements(20);//缓存PreparedStatement的最大数量，默认-1（不缓存）。大于0时会自动开启缓存PreparedStatement，所以可以省略上一句代码
        Connection conn = dds.getConnection();
	}

}
