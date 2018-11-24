package com.guoyasoft.gyautotest.topic.reflect;

import org.testng.annotations.Test;

public class Student {

	private String name;
	private int age;
	private int score;

	public String sayHello(){
		System.out.println("反射执行sayHello()方法");
		return "hello";
	}
	public String sayHello2(){
		System.out.println("反射执行sayHello2()方法");
		return "hello2";
	}
}
