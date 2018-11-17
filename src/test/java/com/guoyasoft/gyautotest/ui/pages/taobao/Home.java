package com.guoyasoft.gyautotest.ui.pages.taobao;

import com.guoyasoft.gyautotest.ui.common.BaseUI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class Home extends BaseUI {

  @FindBy(id="q")
  private WebElement searchInput;

  @FindBy(xpath = "//button[@class='btn-search tb-bg']")
  private WebElement searchBtn;

  @FindBy(xpath = "//li[@id='J_SiteNavMytaobao']")
  private WebElement myTaoBaoLi;

  @FindBy(xpath = "(//a[contains(text(),'女装')])[1]")
  private WebElement girlCloth;

  @Test
  public void search(){
    sendKeys(searchInput, "手机");
    click(searchBtn);
  }

  @Test
  public void toMyTaoBao(){
    click(myTaoBaoLi);
  }

  @Test
  public void toGirlCloth(){
    click(girlCloth);
  }
}
