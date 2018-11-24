package com.guoyasoft.gyautotest.ui.testCase.guoya;

import com.fasterxml.jackson.databind.ser.Serializers.Base;
import com.guoyasoft.gyautotest.ui.common.BaseUI;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

public class GuoYaTest extends BaseUI {

  @Test
  public void testMethod(){
    driver.get("http://47.98.226.232:8080/guoya-client/jsp/interview/statistic/statisticQuery.jsp");
    sleep(2);
    Cookie cookie= driver.manage().getCookieNamed("JSESSIONID");
    driver.manage().deleteCookie(cookie);
    Cookie session=new Cookie("JSESSIONID", "E2DC781E1C408120EDA4324780BEA9B5");
    driver.manage().addCookie(session);
    driver.get("http://47.98.226.232:8080/guoya-client/jsp/interview/statistic/statisticQuery.jsp");
    sleep(2);
  }
}
