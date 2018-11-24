package com.guoyasoft.gyautotest.topic.reflect;

import java.lang.reflect.Field;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GuoyaPageFactory {
	public  Object initPage(WebDriver driver) throws Exception {
		Class login = LoginPage.class;

		login.getPackage().getName();

		LoginPage loginPage = (LoginPage) login.newInstance();
		Field[] fields = login.getDeclaredFields();
		for (Field f : fields) {
			f.getName();
			f.getType();
			f.getModifiers();

			FindBy a = f.getAnnotation(FindBy.class);
			String id = a.id();
			System.out.println("id=" + id);
			WebElement element = driver.findElement(By.id(id));
			f.set(loginPage, element);
		}
		return loginPage;
	}
}
