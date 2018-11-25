package com.guoyasoft.gyautotest.api.testCase.user;

import com.guoyasoft.gyautotest.api.bean.changePwd.ChangePwdReq;
import com.guoyasoft.gyautotest.api.bean.changePwd.ChangePwdResp;
import com.guoyasoft.gyautotest.api.bean.user.login.LoginReq;
import com.guoyasoft.gyautotest.api.bean.user.login.LoginResp;
import com.guoyasoft.gyautotest.api.bean.user.signUp.SignUpReq;
import com.guoyasoft.gyautotest.api.bean.user.signUp.SignUpResp;
import com.guoyasoft.gyautotest.api.common.BaseApi;
import com.guoyasoft.gyautotest.api.service.user.UserApi;
import com.guoyasoft.gyautotest.tools.CSVReader;
import com.guoyasoft.gyautotest.tools.JdbcTools;
import com.guoyasoft.gyautotest.tools.PinYinTools;
import com.guoyasoft.gyautotest.tools.PropertiesTools;
import com.guoyasoft.gyautotest.tools.RandomTool;
import com.guoyasoft.gyautotest.ui.pages.taobao.Login;
import io.qameta.allure.Allure;
import java.util.Map;
import java.util.Properties;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserTest extends BaseApi {

  @Test
  public void loginTest(){
    LoginReq loginReq=new LoginReq();
    loginReq.setUserName("xw123456");
    loginReq.setPwd("a123456");
    UserApi userApi=new UserApi();
    LoginResp loginResp= (LoginResp) httpTools.sendHttpJsonAPI(baseUrl+"/user/login",loginReq,LoginResp.class);
  }

  @Test
  public void signUpTest(){
    Properties prop= PropertiesTools.getProperties("src\\test\\resources\\api\\api.properties");
    SignUpReq signUpReq=new SignUpReq();
    String userName= PinYinTools.toFirstChar(RandomTool.getChineseName())+RandomTool.randomInt(100, 999);
    String phone=RandomTool.getTel();
    System.out.println(userName);
    signUpReq.setUserName(userName);
    signUpReq.setPwd(prop.getProperty("api.common.password"));
    signUpReq.setPhone(phone);
    signUpReq.setRePwd(prop.getProperty("api.common.password"));
    SignUpResp signUpResp=(SignUpResp)httpTools.sendHttpJsonAPI(prop.getProperty("api.host.baseurl")+"/user/signup",signUpReq, SignUpResp.class);
  }



  public void signUpFlowTest(){
    UserApi userApi=new UserApi();
    userApi.signUp();
    userApi.changePwd();
  }

  @Test
  public void changePwd(){
    ChangePwdReq changePwdReq=new ChangePwdReq();
    changePwdReq.setNewPwd("a123456");
    changePwdReq.setOldPwd("a234567");
    changePwdReq.setReNewPwd("a123456");
    changePwdReq.setUserName("wuling999");
    ChangePwdResp changePwdResp=(ChangePwdResp)httpTools.sendHttpJsonAPI(baseUrl+"/user/changepwd", changePwdReq, ChangePwdResp.class);
  }

@Test
  public void lockTest(){
    String sql="select t.user_name,t.pwd from t_user_user t where t.status=0 limit 0,1";
    JdbcTools jdbcTools=new JdbcTools();
    Map result=jdbcTools.getRecord(sql);
    String userName=(String)result.get("user_name");
    String pwd=(String)result.get("pwd");
    System.out.println("用户名："+userName+",密码："+pwd);

    LoginReq loginReq=new LoginReq();
    loginReq.setUserName(userName);
    loginReq.setPwd(pwd);
    LoginResp loginResp= (LoginResp) httpTools.sendHttpJsonAPI(baseUrl+"/user/login", loginReq, LoginResp.class);
  }

  @DataProvider(name="loginData")
  public Object[][] csvProvider(){
    Object[][] data=CSVReader.readCSV("src\\test\\resources\\api\\loginData.csv");
    return data;
  }

  @Test
  public void loginBatch(){
    Object[][] data=CSVReader.readCSV("src\\test\\resources\\api\\loginData.csv");
    for (int i=0;i<data.length;i++){
      Object[] item=data[i];
      LoginReq loginReq=new LoginReq();
      loginReq.setUserName((String)item[0]);
      loginReq.setPwd((String)item[1]);
      LoginResp loginResp= (LoginResp) httpTools.sendHttpJsonAPI(baseUrl+"/user/login", loginReq, LoginResp.class);

    }
  }

  @Test
  public void testMethod(){
    String[] s1={"a","b","c"};
    String[] s2={"A","B","C"};
    String[][] s3={s1,s2};
    String[] x=s3[0];
    String y=s3[0][1];
    System.out.println(y);
  }
}
