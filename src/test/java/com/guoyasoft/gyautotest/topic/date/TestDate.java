package com.guoyasoft.gyautotest.topic.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

public class TestDate {
	@Test
	public void dateToString(){
		//当天
		//Date date=new Date();
		//日期的加减运算
		Calendar c=Calendar.getInstance();
		//当天
		Date date=c.getTime();
		//第二天
		c.add(Calendar.DAY_OF_MONTH, 1);
		Date nextDate=c.getTime();

		//把日期格式化，先定义模板，在根据模板生成字符串
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		String startTime=sf.format(date);
		String endTime=sf.format(nextDate);

		System.out.println("startTime="+startTime);
		System.out.println("endTime="+endTime);
	}

	/*
	 * 存储时间的
	 */
	public void date(){
		Date d=new Date();
		d.getYear();
		d.getMinutes();
		d.getHours();
	}

	/*
	 * 目的：日期的加减运算
	 */
	public void calendar(){
		Calendar calendar=Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		Date d=calendar.getTime();

		calendar.add(Calendar.MONTH, 1);
		Date d2=calendar.getTime();
	}

	/*
	 * 生成时间
	 * 展示时间
	 */
	public void simpleDateFormat() throws ParseException{
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s=sf.format(new Date());

		String date="2018-07-15 10:49:32";
		Date d=sf.parse(date);
	}
}
