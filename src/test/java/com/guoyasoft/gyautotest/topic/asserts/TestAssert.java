package com.guoyasoft.gyautotest.topic.asserts;

import com.guoyasoft.gyautotest.ui.common.BaseUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestAssert extends BaseUI {
	/*
	 * assertLocation（判断当前是在正确的页面）
	 *
	 * assertTextPresent（检查在当前给用户显示的页面上是否有出现指定的文本）、
	 *
	 * assertTextNotPresent（检查在当前给用户显示的页面上是否没有出现指定的文本）、
	 *
	 * assertAttribute（检查当前指定元素的属性的值）、
	 *
	 * assertTitle（检查当前页面的title是否正确）、
	 *
	 * assertEditable（检查指定的input是否可以编辑）、
	 *
	 * assertNotEditable（检查指定的input是否不可以编辑）、
	 *
	 * waitForElementPresent （等待检验某元素的存在。为真时，则执行。)
	 *
	 * assertValue（检查input的值， checkbox或radio，有值为”on”无为”off”）、
	 *
	 * assertSelected（检查select的下拉菜单中选中是否正确）、
	 *
	 * assertSelectedOptions（检查下拉菜单中的选项的是否正确）、
	 *
	 * assertText（检查指定元素的文本）、
	 *
	 * assertTable（检查table里的某个cell中的值）、
	 *
	 * assertAlert（检查是否有产生带指定message的alert对话框）、
	 *
	 */

	/*
	 * 核心：1、driver获取界面的地址、title、pageSource
	 * 		2、webelement能过获取属性attribute
	 * 		2.4.3_69_71、string字符串的各种操作和对比
	 * 		4、Assert一旦没通过，后续动作不执行
	 * 		5、如果Assert失败，要继续执行，或者走异常分支，用try{}catch(Error e){异常要做的事}
	 *
	 */

	//assertLocation（判断当前是在正确的页面）
	@Test
	@Parameters({ "url" })
	public void assertLocationTrue(String url) {
		String currentUrl = driver.getCurrentUrl();
		boolean actual = url.equals(currentUrl);
		Assert.assertEquals(actual, true);
	}

	//assertLocation（判断当前是在正确的页面）
	@Test
	@Parameters({ "url" })
	public void assertLocationFalse(String url) {
		driver.get("https://www.baidu.com");
		String currentUrl = driver.getCurrentUrl();
		boolean actual = url.equals(currentUrl);
		Assert.assertEquals(actual, false);
	}

	@Test
	public void assertTitle() {
		driver.get("https://www.baidu.com");
		sleep(2000);
		String currenTitle = driver.getTitle();
		boolean actual = "百度一下，你就知道".equals(currenTitle);
		Assert.assertEquals(actual, true);
		System.out.println("判断注册界面是否ok？");
	}

	@Test
	public void assertTextPresent() {
		String pageSource = driver.getPageSource();
		boolean actual = pageSource.contains("hao123");
		Assert.assertEquals(actual, true);
	}

	@Test
	public void assertAttribute() {
		WebElement submitBtn = driver.findElement(By.id("submitBtn"));
		String disabled = submitBtn.getAttribute("disabled");
		System.out.println(disabled);
		boolean actual = !"disabled".equals(disabled);
		Assert.assertEquals(actual, true);
		submitBtn.click();
	}

	@Test
	public void assertEditable() {
		WebElement realName = driver.findElement(By.id("realName"));
		String readonly = realName.getAttribute("readonly");
		boolean actual = !"readonly".equals(readonly);
		Assert.assertEquals(actual, true);
		realName.clear();
		realName.sendKeys("果芽软件");
	}

	@Test
	public void assertElementPresent() {
		boolean actual = false;
		try {
			WebElement reset = driver.findElement(By
					.xpath("//input[@type='reset']"));
			actual = true;
		} catch (Exception e) {
			e.printStackTrace();
			actual = false;
		}
		Assert.assertEquals(actual, true);
	}

	@Test
	public void assertElementDisplay() {
		WebElement reset = driver
				.findElement(By.xpath("//input[@type='reset']"));
		String hidden = reset.getAttribute("hidden");
		boolean actual = !"hidden".equals(hidden);
		Assert.assertEquals(actual, true);
		reset.click();
	}
}
