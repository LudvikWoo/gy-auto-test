package com.guoyasoft.gyautotest.topic.extendsAndImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Wuling implements Student,Employee{

	@Override
	public void study(String courseName) {
		System.out.println("学习"+courseName);
	}

	@Override
	public void exame() {
		System.out.println("考试");

	}

	@Override
	public void toWork() {
		System.out.println("工作");

	}

	@Override
	public void work() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getSalary() {
		// TODO Auto-generated method stub

	}


//	public static void main(String[] args) {
//		//容器，1个数据，需要1个变量；1个容器，可以放很多个数据
//		//set放数据，去重
//		Set<String> set=new HashSet<String>();
//		set.add("guoya1");
//		set.add("guoya2");
//		set.add("guoya3");
//		set.add("guoya1");
//		set.add("guoya3");
//		set.add("guoya4");
//
//		for(String s:set){
//			System.out.println("set:"+s);
//		}
//		//放数据，不去重
//		List<String> list=new ArrayList<String>();
//		list.add("guoya1");
//		list.add("guoya2");
//		list.add("guoya3");
//		list.add("guoya1");
//		list.add("guoya3");
//		list.add("guoya4");
//
//		for(String s:list){
//			System.out.println("list:"+s);
//		}
//	}
}
