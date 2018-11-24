package com.guoyasoft.gyautotest.topic.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

public class TestString {

	@Test
	public void isBlank(){
		//已经分配内存，但是没有存数据
		String s2="";
		//没有分配内存
		String s3=null;
		//已经分配内存，并且存了数据“hello"
		String s4="hello";

		if(s2!=null && !"".equals(s2) && !s2.equalsIgnoreCase("null")){
			System.out.println("s2不为空");
		}else{
			System.out.println("s2为空");
		}

		if(s3!=null && !"".equals(s3) && !s3.equalsIgnoreCase("null")){
			System.out.println("s3不为空");
		}else{
			System.out.println("s3为空");
		}

		if(s4!=null && !"".equals(s4) && !s4.equalsIgnoreCase("null")){
			System.out.println("s4不为空");
		}else{
			System.out.println("s4为空");
		}
	}

	@Test
	public void length(){
		String str="上海果芽软件科技有限公司";
		//java里面会用方法去封装变量的存取，便于控制。符合“面向函数”编程的趋势
		int length=str.length();
		System.out.println("length()：字符串长度="+length);
	}

	@Test
	public void addStr(){
		//String类型分配内存大小，s1给跟配的内存地址取个访问名字，=赋值符，“上海果芽软件”是内存要存的数据
		String s1="上海果芽软件";
		String s2="科技有限公司";
		String s3=s1+s2;
		System.out.println("s1+s2="+s3);

		int a=10;
		String s4=s1+a;
		System.out.println("s1+int="+s4);
	}

	@Test
	public void equals(){
		String s1="果芽软件";
		String s2="果芽软件";
		String s3="果芽";
		boolean isEqual=s1.equals(s2);
		System.out.println("s1是否等于s2："+isEqual);

		isEqual=s1.equals(s3);
		System.out.println("s1是否等于s3："+isEqual);

		String s4="abcd";
		String s5="Abcd";
		isEqual=s4.equals(s5);
		System.out.println("s4是否等于s5(大小写敏感)："+isEqual);
		isEqual=s4.equalsIgnoreCase(s5);
		System.out.println("s4是否等于s5(忽略大小写)："+isEqual);

		String s6="abc";
		String s7=null;
		String s8="bcd";
		isEqual=s7.equals(s6);//空指针异常
		isEqual=s6.equals(s7);//越确定的，越要写在前面，如果都不为空，前后顺序没有关系，所以一般变量放后面，确定的字符串放前面

	}
	@Test
	public void uperAndLow(){
		String s1="asdAsdf";
		String s2=s1.toLowerCase();//asdasdf
		String s3=s1.toUpperCase();//ASDASDF
		System.out.println("s2="+s2+";s3="+s3);
	}

	@Test
	public void contains(){
		String s1="上海果芽软件科技有限公司";
		String s2="果芽";
		String s3="责任";

		boolean isContain=s1.contains(s2);
		System.out.println("s1是否包含s2："+isContain);

		isContain=s1.contains(s3);
		System.out.println("s1是否包含s3："+isContain);
	}

	@Test
	public void indexOf(){
		String s1="上海果芽软件科技有限公司";
		String s2="果芽";
		int index=s1.indexOf(s2);
		System.out.println("s1中“果芽”的位置："+index);

		String s3="上海果芽软件科技有限公司简称果芽软件";
		String s4="果芽";
		index=s3.lastIndexOf(s4);
		System.out.println("s3中“果芽”最后出现的位置："+index);
	}


	@Test
	public void strSplit(){
		//分隔符固定，内容长度不固定
		String str="guoyasoft|software testing|shanghai";
		//把多个值同时用一个变量存起来，就得用到容器：单值（数组、arraylist、hashset），键值对（hashmap）
		String[] result=str.split("|");
		//变量容器内的所有内容，用for each
		for(String s:result){
			System.out.println(s);
		}
		//前端界面传的金额、年龄等为字符串，后端要进行数字计算，必须转成对应类型的数字
		String param="ct=17&pn=0&tn=ikaslist&rn=10&fr=wwwt&word=简历%20英文";
		String[] params=param.split("&");
		for(String s:params){
			String[] entry=s.split("=");
			String key=entry[0];
			String value=entry[1];
		}
	}

	@Test
	public void subString(){
		//没有固定分割符，但是位置固定
		String s1="上海果芽软件科技有限公司";
		String s2=s1.substring(2);
		System.out.println("截取s1的第2个位置到末尾的字符串："+s2);

		String s3=s1.substring(2,6);
		System.out.println("截取s1的第2位到第6位的字符串："+s3);
		//解析身份证号
	}

	@Test
	public void intToStr(){
		int a=20;
		String strA=a+"";
		System.out.println("a="+strA);
	}


	@Test
	public void strToNumber(){
		String s="10";
		//包装类。因为基本类型（byte(Byte)、short(Short)、int(Integer)、long(Long)、float(Float)、double(Double)不是类，然后方法只能放在类里面）
		int a=Integer.parseInt(s);
		System.out.println("a="+a);

		String s2="10.23";
		double b=Double.parseDouble(s2);
		System.out.println("b="+b);

		//前端界面传的金额、年龄等为字符串，后端要进行数字计算，必须转成对应类型的数字
	}

	@Test
	public void strToDate() throws ParseException{
		String str="2018-04-23 21:41:23";
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//字符串转时间
		Date date=sf.parse(str);
		//时间转字符串

		SimpleDateFormat sf2=new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
		String newStr=sf2.format(date);
		System.out.println(newStr);

		SimpleDateFormat sf3=new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
		String newStr3=sf3.format(date);
		System.out.println(newStr3);
	}

	@Test
	public void numberToDate() throws ParseException{
		String str="2018-04-23 21:41:23";
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//字符串转时间
		Date date=sf.parse(str);
		//时间转字符串
		//当前日期-计算机元年，单位：毫秒
		//计算机元年：（1970-01-01 00:00:00），类似民国35年，贞观14年，万历15年
		long time1=date.getTime();
		long time2=new Date().getTime();
		System.out.println(time2-time1);
	}

	@Test
	public void trim() throws ParseException{
		String str=" 果芽软件";
		String str2=" 果芽软件  ";
		String str3="果芽软件";
		//trim()方法，就是把字符串前后的空格给去掉
		System.out.println("str1="+str.trim());
		System.out.println("str2="+str2.trim());
		System.out.println("str3="+str3.trim());
	}
}
