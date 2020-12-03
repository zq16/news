package com.hnjdzy.news.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class testSqlDateToDate {

	@Test
	public void test() {
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		String formatDate = df.format(date);
		System.out.println(formatDate);

	}

}
