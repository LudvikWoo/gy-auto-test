package com.guoyasoft.gyautotest.api.testCase.user;

import com.guoyasoft.gyautotest.api.service.user.UserApi;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;

public class UserTest {

  @Test
  public void loginTest(){
    UserApi userApi=new UserApi();
    userApi.login("xxxx", "123");
    Allure.addAttachment("登录请求：", "userName=xxxx&&password=1234");
  }

  public void loginNullTest(){
    UserApi userApi=new UserApi();
    userApi.login(null, "123");
    Allure.addAttachment("登录请求：", "userName=xxxx&&password=1234");
  }

  public void signUpFlowTest(){
    UserApi userApi=new UserApi();
    userApi.signUp();
    Allure.addAttachment("第一步：注册", "xxxxxxxxx");
    userApi.login("xxxx", "11212");
    Allure.addAttachment("第二步：登录", "xxxxxxxxx");
    userApi.changePwd();
    Allure.addAttachment("第三步：改密码", "xxxxxxxxx");
  }
}
