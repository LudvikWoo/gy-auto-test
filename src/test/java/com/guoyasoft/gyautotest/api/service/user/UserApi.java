package com.guoyasoft.gyautotest.api.service.user;

import com.alibaba.fastjson.JSON;
import com.guoyasoft.gyautotest.api.bean.user.login.LoginReq;
import com.guoyasoft.gyautotest.api.bean.user.login.LoginResp;
import com.guoyasoft.gyautotest.api.testCase.account.AccountTest;
import com.guoyasoft.gyautotest.tools.HttpTools;
import org.testng.annotations.Test;

public class UserApi <T extends Object >{

  public LoginResp login(LoginReq request){
    String reqJson= JSON.toJSONString(request,true);
    System.out.println("-----请求报文：-----------");
    System.out.println(reqJson);
    String respJson=HttpTools.doPostByJson("", reqJson, "UTF-8", "application/json");
    System.out.println("-------------响应报文------------");
    System.out.println(respJson);
    LoginResp resp=JSON.parseObject(respJson,LoginResp.class);
    return resp;
  }

  public T login2(Object request,Class<T> response){
    String reqJson= JSON.toJSONString(request,true);
    System.out.println("-----请求报文：-----------");
    System.out.println(reqJson);
    String respJson=HttpTools.doPostByJson("http://qa.guoyasoft.com:8080/user/login", reqJson, "UTF-8", "application/json");
    System.out.println("-------------响应报文------------");
    System.out.println(respJson);
    T resp=(T)JSON.parseObject(respJson,response);
    return resp;
  }

  public void signUp(){
    System.out.println("-------------用户模块：注册------------");
  }


  public void changePwd(){
    System.out.println("-------------用户模块：改密码------------");
  }


  @Test
  public void lock(){
    System.out.println("-------------用户模块：冻结用户------------");
  }

  @Test
  public void unLock(){
    System.out.println("-------------用户模块：解锁用户------------");
  }

}
