package com.guoyasoft.gyautotest.topic.testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG2 {


	@BeforeClass
	public void m6(){
		System.out.println("m6");
	}
	@Test
	public void m7(){
		System.out.println("m7");
	}

	@Test
	public void m8(){
		System.out.println("m8");
	}

	@AfterClass
	public void m9(){
		System.out.println("m9");
	}

}
