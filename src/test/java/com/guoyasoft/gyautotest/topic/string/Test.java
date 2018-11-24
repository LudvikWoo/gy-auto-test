package com.guoyasoft.gyautotest.topic.string;

public class Test {
	public static void main(String[] args) {
		String cert="500234198812061846";
		String sex=cert.substring(cert.length()-2,cert.length()-1);
		System.out.println(sex);
		if(Integer.parseInt(sex)%2==0){
			System.out.println("男");
		}else{
			System.out.println("女");
		}
	}
}
