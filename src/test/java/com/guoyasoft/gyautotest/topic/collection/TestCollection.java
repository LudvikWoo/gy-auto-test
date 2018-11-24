package com.guoyasoft.gyautotest.topic.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class TestCollection {
	/*
	 * 增（新建对象，新增数据）、删、改、查（取单个、批量取）
	 */

	// 有序、大小固定、单个值：存放容器（数组）
	@Test
	public void array() {
		//数据类型

		//1. 基本数据类型：8种
		byte a=120;//8位
		short b=12122;//16位
		char c='a';//16位  1010110011
		int d=234;//32位
		long e=23423;//64位

		float f=23.23f;//32位
		double g=2323.234;//64位

		boolean h=true;//32位

		//2. 引用数据类型：
		String s1223="sdfsdf";
		Person p=new Person();
		WebDriver driver=new ChromeDriver();

		Person[] persons=new Person[23];
		Person[] persons2={new Person(),new Person()};
		String s2=new String("sdf");

		int[] ints=new int[4];

		// 1. 新建数组
		String[] array = new String[4];
		String[] array2 = { "a", "b", "c", "d" };
		// 2. 增加数据
		array[0] = "a";
		array[1] = "b";
		array[2] = "c";
		array[3] = "d";

		// 2.4.3_69_71. 修改数据
		array[2] = "f";

		// 4.1 取数据(单个)
		String s = array[3];


		// 4.2 取数据（批量）
		for (int i = 0; i < array.length; i++) {
			String item = array[i];
			System.out.println(item);
		}

		for (String item : array) {
			System.out.println(item);
		}

	}

	// 有序、大小不固定、单个值：存放容器（ArrayList）
	@Test
	public void list() {
		// List接口，有一个ArrayList实现类
		List<String> list = new ArrayList<String>();

		// 添加数据
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");

		// 修改数据
//		list.add(2, "f");

		// 取数据：单个
		String s = list.get(1);

		// 取批量数据
		for (int i = 0; i < list.size(); i++) {
			String item = list.get(i);
			System.out.println(item);
		}

		for (String item : list) {
			System.out.println(item);
		}
	}

	/*
	 * hashset和hashmap是无序的集合 无序的集合，需要先排序
	 *
	 * 排序后的队列：iterator（迭代器）
	 */

	// 无序、大小不固定、单个值：存放容器（HashSet）
	@Test
	public void set() {
		Set<String> sets = new HashSet<String>();
		// 增加(自动去重）
		sets.add("a");
		sets.add("b");
		sets.add("c");
		sets.add("d");
		sets.add("a");

		// 取单个数据(无序的容器，没法取）

		// 取批量，因为无序，所有要先排序(iterator就是队列）
		// 判断是否有下一个，如果有，通过next()取下一个
		Iterator<String> iterator = sets.iterator();
		while (iterator.hasNext()) {
			String item = iterator.next();
			System.out.println(item);
		}
	}

	// 无序、大小不固定、键值对：存放容器（HashSet）
	@Test
	public void hashMap() {
		Map<String, String> map = new HashMap<String, String>();
		// 增加数据
		map.put("name", "guoya");
		map.put("age", "1");
		map.put("addr", "上海浦江镇");

		// 修改数据
		map.put("addr", "上海市闵行区浦江镇");

		// 取单个：
		String name = map.get("name");
		String age = map.get("age");

		// 取批量：无序容器，要先排序
		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> item = iterator.next();
			String key = item.getKey();
			String value = item.getValue();
		}
	}

	// 无序、大小不固定、键值对：存放容器（HashSet）
	@Test
	public void testJavaBean() {
		// 无序、大小固定、键值对：存放容器（JavaBean）
		Person p = new Person();
		p.setName("guoya");
		p.setAge(1);

		String name = p.getName();
	}

}
