package com.guoyasoft.gyautotest.ui.testCase.baidu;

import com.guoyasoft.gyautotest.ui.common.BaseUI;
import com.guoyasoft.gyautotest.ui.pages.baidu.BaiduDetail;
import com.guoyasoft.gyautotest.ui.pages.baidu.BaiduHome;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaiduHomeTest extends BaseUI {

  @Test
  @Parameters({"sessionName", "sessionValue"})
  public void search(String sessionName, String sessionValue) {
    driver.get("https://www.baidu.com");
    //snapshot((TakesScreenshot)driver, "baiduHome.jpg");
    //this.saveSvgAttachment(driver);
    addScreenshot2Allure("打开百度首页");
    BaiduHome baidu = PageFactory.initElements(driver, BaiduHome.class);
    baidu.search("果芽软件");
    //snapshot((TakesScreenshot)driver, "baidu_search.jpg");

    addScreenshot2Allure("查询果芽软件");
    BaiduDetail detail = PageFactory.initElements(driver, BaiduDetail.class);
    detail.showBaiduBaiKe();
    switchToTitleWindow("_百度百科");
    //snapshot((TakesScreenshot) driver, "baidu_detail.jpg");

    addScreenshot2Allure("打开百度百科");
  }

  @Attachment(value = "Sample svg attachment", type = "image/jpeg")
  public static byte[] saveSvgAttachment(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

}
