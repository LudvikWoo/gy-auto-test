package com.guoyasoft.gyautotest.ui.pages.taobao;

import com.guoyasoft.gyautotest.ui.common.BaseUI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Login extends BaseUI {
  @FindBy(xpath = "//i[@id='J_Quick2Static']")
  private WebElement loginType;

  @FindBy(xpath = "//input[@id='TPL_username_1']")
  private WebElement userName;

  @FindBy(xpath = "//input[@id='TPL_password_1']")
  private WebElement password;

  @FindBy(xpath = "//button[@id='J_SubmitStatic']")
  private WebElement loginBtn;

  @Test
  public void login(){
    click(loginType);
    sendKeys(userName, "wuling");
    sendKeys(password, "123456");
    click(loginBtn);
  }
}
