package com.guoyasoft.gyautotest.topic.testNG.parameter;

import javax.annotation.PreDestroy;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG {
	//数据驱动测试：代码不变，通过给代码传不同的数据，代码进行不同的测试
	@Test
	@Parameters({"class","name"})
	public void hello(String className,String studentName){
		System.out.println("你好，"+className+"的"+studentName+"！");
		boolean actual=false;
		if(className != null && className.length()>0 && studentName !=null && studentName.length()>0){
			actual=true;
		}
		Assert.assertEquals(actual, true);
	}
}
