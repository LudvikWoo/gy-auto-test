package com.guoyasoft.gyautotest.ui.testCase.jd;

import com.guoyasoft.gyautotest.ui.common.BaseUI;
import com.guoyasoft.gyautotest.ui.pages.jd.JDHomePage;
import com.guoyasoft.gyautotest.ui.pages.jd.LoginPage;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JDTest extends BaseUI {

  @Test
  public void accLogin(){
    driver.get("https://www.jd.com");
    snapshot((TakesScreenshot) driver, "selenium/jd/homePage.jpg");
    Assert.assertEquals(driver.getTitle().contains("京东"), true);

    JDHomePage jdHomePage= PageFactory.initElements(driver, JDHomePage.class);
    jdHomePage.toLogin();
    snapshot((TakesScreenshot) driver, "selenium/jd/loginPage.jpg");
    Assert.assertEquals(driver.getPageSource().contains("登录页面"), true);

    LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
    loginPage.accLogin("LudvikWoo", "com.JD.Wl3");
    snapshot((TakesScreenshot) driver, "selenium/jd/loginAction.jpg");
    Assert.assertEquals(driver.getPageSource().contains("账户名与密码不匹配"), true);
  }
}
