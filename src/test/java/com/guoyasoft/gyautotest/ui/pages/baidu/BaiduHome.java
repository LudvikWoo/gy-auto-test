package com.guoyasoft.gyautotest.ui.pages.baidu;

import com.guoyasoft.gyautotest.ui.common.BaseUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BaiduHome extends BaseUI {
	public BaiduHome(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//*[@id='kw']")
	public WebElement input;

	@FindBy(xpath="//*[@id='su']")
	public WebElement search;

	public void search(String content){
		sendKeys(input, content);
		click(search);
	}
}
