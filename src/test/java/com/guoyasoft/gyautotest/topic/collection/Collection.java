package com.guoyasoft.gyautotest.topic.collection;

import com.guoyasoft.gyautotest.tools.CSVReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Collection {
	Map<String, String> vars = new HashMap<String, String>();

	public void userDefinedVariable() {
		vars.put("userName", "guoya");
		vars.put("password", "123456");
	}

	@Test
	public void httpRequest(String method,String protocal,String ip,String port,String context,String params) {
		String url =method+" "+protocal+ "://"+method+":"+port+"/guoya-cient/login.action?userName="
				+ vars.get("userName") + "&password=" + vars.get("password");
	}

	@BeforeMethod
	public void preProcessor(){

	}

	@AfterMethod
	public void postProcess(){

	}

	public void debugSimple(){
		Iterator<Map.Entry<String, String>> iterator=vars.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<String, String> item=iterator.next();
			System.out.println(item.getKey()+"="+item.getValue());
		}
	}

	public void testCsv(){
		Object[][] datas= CSVReader.readCSV("C:\testJmeterCsv.csv");
		for(int i=0;i<datas.length;i++){
			vars.put("userName", (String) datas[i][0]);
			String password=(String) datas[i][1];
			String checkCode=(String) datas[i][3];
			String request="GET http://www.guoyasoft.com:8080/guoya-client/login.action?userName="+vars.get("userName")+"&password="+password+"&checkCode="+checkCode;
		}
	}
}
