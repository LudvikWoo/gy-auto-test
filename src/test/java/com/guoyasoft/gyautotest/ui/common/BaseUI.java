package com.guoyasoft.gyautotest.ui.common;

import io.qameta.allure.Allure;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseUI {
	public WebDriver driver;
	public String pageTitle;
	public String pageUrl;

	public BaseUI(){

	}

	public BaseUI(WebDriver driver){
		this.driver=driver;
	}

	@BeforeClass
	public void before(){
		//打开浏览器
		// 设置环境变量，指定chromedriver的路径
				System.setProperty("webdriver.chrome.driver",
						"src\\test\\resources\\selenium\\driver\\243_69_71\\chromedriver.exe");
				// 设置浏览器的参数
				ChromeOptions options = new ChromeOptions();
				// 最大化浏览器
				options.addArguments("--test-type", "--start-maximized");
				// options.setBinary("C:/XXXXXXX/chrome.exe");
				// 打开浏览器
				driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
				sleep(1);


	}

	@Test
	public void openUrl(String url){
		//打开URL
		driver.get(url);
		sleep(1);

	}

	@AfterClass
	public void after(){
		//关闭浏览器
		sleep(1);
		driver.quit();
	}

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void snapshot(TakesScreenshot drivername, String filename) {
		// this method will take screen shot ,require two parameters ,one is
		// driver name, another is file name

		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		try {
			System.out.println("save snapshot path is:c:/" + filename);
			FileUtils.copyFile(scrFile, new File("c:\\" + filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Can't save screenshot");
			e.printStackTrace();
		} finally {
			System.out.println("screen shot finished");
		}
	}
	/*
	 * 在文本框内输入字符
	 */
	protected void sendKeys(WebElement element, String text) {
		try {
			if (element.isEnabled()) {
				element.clear();
				System.out.println("Clean the value if any in "
						+ element.toString() + ".");
				element.sendKeys(text);
				System.out.println("Type value is: " + text + ".");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * 点击元素，这里指点击鼠标左键
	 */
	protected void click(WebElement element) {

		try {
			if (element.isEnabled()) {
				element.click();
				System.out.println("Element: " + element.toString()
						+ " was clicked.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * 在文本输入框执行清除操作
	 */
	protected void clean(WebElement element) {

		try {
			if (element.isEnabled()) {
				element.clear();
				System.out.println("Element " + element.toString()
						+ " was cleaned.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * 判断一个页面元素是否显示在当前页面
	 */
	protected void verifyElementIsPresent(WebElement element) {

		try {
			if (element.isDisplayed()) {
				System.out.println("This Element " + element.toString().trim()
						+ " is present.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 获取页面的标题
	 */
	protected String getCurrentPageTitle() {

		pageTitle = driver.getTitle();
		System.out.println("Current page title is " + pageTitle);
		return pageTitle;
	}

	/*
	 * 获取页面的url
	 */
	protected String getCurrentPageUrl() {

		pageUrl = driver.getCurrentUrl();
		System.out.println("Current page title is " + pageUrl);
		return pageUrl;
	}

	public void switchToNextWindow() {

		String currentWindow = driver.getWindowHandle();// 获取当前窗口句柄
		Set<String> handles = driver.getWindowHandles();// 获取所有窗口句柄
		System.out.println("当前窗口数量： " + handles.size());
		for (String s : handles) {
			if (currentWindow.endsWith(s)) {
				continue;
			} else {
				try {
					WebDriver window = driver.switchTo().window(s);// 切换到新窗口
					System.out
							.println("new page title is " + window.getTitle());
					break;
				} catch (Exception e) {
					System.out.println("法切换到新打开窗口" + e.getMessage());

				}
			}
		}
	}

	public void switchToTitleWindow(String windowTitle) {
		// 将页面上所有的windowshandle放在入set集合当中
		String currentHandle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String s : handles) {
			driver.switchTo().window(s);
			// 判断title是否和handles当前的窗口相同
			if (driver.getTitle().contains(windowTitle)) {
				break;// 如果找到当前窗口就停止查找
			}
		}
	}

	@Test
	public void loginByCookie(String cookieName,String cookieValue){
		Cookie cookie= driver.manage().getCookieNamed(cookieName);
		driver.manage().deleteCookie(cookie);
		Cookie session=new Cookie(cookieName, cookieValue);
		driver.manage().addCookie(session);
	}

	public void addScreenshot2Allure(String stepName){
		Allure.addByteAttachmentAsync(stepName, "image/jpeg", new Supplier<byte[]>() {
			@Override
			public byte[] get() {
				return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			}
		});
	}
}
