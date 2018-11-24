package com.guoyasoft.gyautotest.ui.pages.jd;

import com.guoyasoft.gyautotest.ui.common.BaseUI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseUI {

  @FindBy(partialLinkText = "账户登录")
  private WebElement accLoginA;

  @FindBy(id = "loginname")
  private WebElement loginNameInput;

  @FindBy(id = "nloginpwd")
  private WebElement passwordInput;

  @FindBy(id = "loginsubmit")
  private WebElement loginBtn;

  public void accLogin(String userName,String password){
    click(accLoginA);
    sendKeys(loginNameInput, userName);
    sendKeys(passwordInput, password);
    click(loginBtn);

  }

}
