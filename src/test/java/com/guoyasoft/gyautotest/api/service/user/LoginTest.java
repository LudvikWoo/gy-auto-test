package com.guoyasoft.gyautotest.api.service.user;

import com.alibaba.fastjson.JSON;
import com.guoyasoft.gyautotest.api.bean.user.login.LoginReq;
import com.guoyasoft.gyautotest.tools.HttpTools;
import io.qameta.allure.Allure;
import java.util.ArrayList;
import org.testng.annotations.Test;

public class LoginTest {
  @Test
  public void login(){
    LoginReq loginReq=new LoginReq();
    loginReq.setPwd("a123456");
    loginReq.setUserName("xw123456");
    String reqJson= JSON.toJSONString(loginReq);
    Allure.addAttachment("请求报文", reqJson);

    String respJson= HttpTools.doPostByJson("http://qa.guoyasoft.com:8080/user/login", reqJson);
    Allure.addAttachment("响应报文", respJson);
  }


}
