package com.guoyasoft.gyautotest.ui.pages.jd;

import com.guoyasoft.gyautotest.ui.common.BaseUI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class JDHomePage extends BaseUI {
  @FindBy(id="key")
  private WebElement searchInput;

  @FindBy(xpath = "//div[@id='search']//button[@class='button']")
  private WebElement searchBtn;

  @FindBy(xpath = "(//a[@href='javascript:login();'])[1]")
  private WebElement toLoginA;

  @FindBy(xpath = "(//a[@href='//miaosha.jd.com/'])[1]")
  private WebElement secKillA;

  @Test
  public void search(String searcContent){
    sendKeys(searchInput, searcContent);
    click(searchBtn);
  }

  @Test
  public void toLogin(){
    click(toLoginA);
  }

  @Test
  public void secKill(){
    click(secKillA);
  }
}
