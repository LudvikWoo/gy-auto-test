package com.guoyasoft.gyautotest.ui.pages.baidu;

import com.guoyasoft.gyautotest.ui.common.BaseUI;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class BaiduDetail extends BaseUI {

	@FindBy(partialLinkText="百度百科")
	public WebElement link;

	public void showBaiduBaiKe(){
		click(link);
	}
}
