package com.guoyasoft.gyautotest.ui.testCase.baidu;

import com.guoyasoft.gyautotest.ui.common.BaseUI;
import com.guoyasoft.gyautotest.ui.pages.baidu.BaiduDetail;
import com.guoyasoft.gyautotest.ui.pages.baidu.BaiduHome;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class BaiduHomeTest extends BaseUI {

	@Test
	public void search() {
			driver.get("https://www.baidu.com");
			snapshot((TakesScreenshot)driver, "baiduHome.jpg");
			BaiduHome baidu = PageFactory.initElements(driver, BaiduHome.class);
			baidu.search("果芽软件");
			snapshot((TakesScreenshot)driver, "baidu_search.jpg");
			BaiduDetail detail = PageFactory.initElements(driver, BaiduDetail.class);
			detail.showBaiduBaiKe();
			switchToTitleWindow("_百度百科");
			snapshot((TakesScreenshot)driver, "baidu_detail.jpg");

	}
}
