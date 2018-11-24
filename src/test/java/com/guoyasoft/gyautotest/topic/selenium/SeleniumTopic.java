package com.guoyasoft.gyautotest.topic.selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTopic {
	private WebDriver driver;

	@Test
	public void driverOpenAndClose(){
		//打开浏览器
		driver=new ChromeDriver();
		//关闭浏览器
		driver.quit();
		//关闭窗口
		driver.close();
		/*
		 * 操作地址栏
		 */
		driver.get("http://www.baidu.com");
		driver.navigate().to("http://www.baidu.com");
		driver.navigate().back();
		driver.navigate().refresh();

		/*
		 * 打开界面后断言
		 */
		//对地址栏的断言
		String currentUrl=driver.getCurrentUrl();
		boolean actual="http://www.baidu.com".equals(currentUrl);
		Assert.assertEquals(actual, true);
		//对title断言
		String title=driver.getTitle();
		actual="百度一下，你就知道".equals(title);
		Assert.assertEquals(actual, true);
		//对界面内容断言
		String pageSource=driver.getPageSource();
		actual=pageSource.contains("百度");

		/*
		 * cookie管理，是跳过登录（核心是跳过验证码的一种解决方案，直接不要登录界面，把登录界面要做的事，也即生成和返回token或sessionID给干掉）
		 */
		Cookie cookie=new Cookie("token", "ASDFSDKFJSLDFJKSLKDF");
		driver.manage().addCookie(cookie);
		//隐式等待元素定位，作用于所有getElementBy
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MICROSECONDS);
		//等待界面加载超时
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		/*
		 * 定位元素 :findElement
		 */
		WebElement element1=driver.findElement(By.id("xxx"));
		WebElement element2=driver.findElement(By.name("xxx"));
		List<WebElement> elements=driver.findElements(By.name("xxx"));
		WebElement element3=driver.findElement(By.xpath("//xxx[@id='' and @name='' or @type='' ]"));
		//两种超链接的定位：精确定位、模糊匹配
		WebElement element4=driver.findElement(By.linkText("百度"));
		WebElement element5=driver.findElement(By.partialLinkText("百度"));

		/*
		 * 切换窗口
		 */
		Alert alert=driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		alert.sendKeys("");
		//断言alert框是否正确：主要看提示内容
		alert.getText();

		//切换frame框，frame框是一个正常界面，不需要存储为特殊对象，只有alert特殊
		driver.switchTo().frame("id或者name");

		//正常窗口切换
		//每个窗口有一个句柄（windowHandle，相当于身份证号，唯一）
		String currentHandle=driver.getWindowHandle();
		//因为一定要保障句柄的唯一性，而且是单个的值，大小还不确定，所以用set容器
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> iterator=handles.iterator();
		while(iterator.hasNext()){
			String windowHandle=iterator.next();
			driver.switchTo().window(windowHandle);
			String t=driver.getTitle();//或者判断url、或者判断pageSource
			actual="果芽软件".equals(t);
			if(actual==true){
				break;
			}
		}
		driver.switchTo().window(currentHandle);//切回原窗口

		/*
		 * 执行JavaScript代码
		 */
		JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
		jsExecutor.executeScript("JavaScript脚本");


		/*
		 * 元素的处理
		 */
		element1.clear();
		element1.sendKeys("");
		element1.click();

		//对元素进行断言，设置检查点
		String value=element1.getAttribute("属性名");//displayed：是否可见；hidden：是否隐藏；disabled：是否可点击；readOnly：只读；editabled：是否可编辑

		//<input type="text" name="userName" style="color:red ; width:50px ; "	>
		element1.getCssValue("color");//返回值是red
		String tagNam=element1.getTagName();

		/*
		 * 特殊元素
		 */
		WebElement selectElement=driver.findElement(By.id(""));
		Select select=new Select(selectElement);
		select.selectByIndex(0);
		select.selectByValue("2");
		select.selectByVisibleText("橙子");

		/*
		 * 鼠标和键盘
		 */
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.CONTROL).click(element5).keyUp(Keys.CONTROL).perform();
		actions.doubleClick();
		actions.dragAndDrop(element1, element4);
		actions.moveToElement(element3);
		actions.sendKeys(element3, "sdfsdf");



	}
}
