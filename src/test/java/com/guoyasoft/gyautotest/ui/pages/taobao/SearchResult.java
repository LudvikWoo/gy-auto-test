package com.guoyasoft.gyautotest.ui.pages.taobao;

import com.guoyasoft.gyautotest.ui.common.BaseUI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class SearchResult extends BaseUI {
  @FindBy(xpath = "//div[@id='J_NavCommonRowItems_0']//span[contains(text(),'小米')]")
  private WebElement miA;

  @FindBy(xpath = "(//a[@class='product-title'])[1]")
  private WebElement firstSKU;

  @Test
  public void selectMI(){
    click(miA);
  }

  @Test
  public void chooseSKU(){
    click(firstSKU);
  }
}
