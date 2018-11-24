package com.guoyasoft.gyautotest.topic.extendsAndImpl;

public class Test {

	public static void main(String[] args) {
		Girl baby=new Girl("至尊宝", "紫霞仙子");
		baby.birthday="2018-04-13 09:12:30";
		baby.name="初夏";
		baby.sex="女";
		baby.weight="8.8";
		baby.welcomeWord="八阿哥";
		System.out.println(baby.toString());
	}
}
