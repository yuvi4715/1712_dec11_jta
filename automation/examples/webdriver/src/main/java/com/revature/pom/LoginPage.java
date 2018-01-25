package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	static WebElement e = null;

	public static WebElement user(WebDriver d) {
		e = d.findElement(By.name("userName"));
		return e;
	}
	
	public static WebElement password(WebDriver d) {
		e = d.findElement(By.name("password"));
		return e;
	}
	
	public static WebElement signin(WebDriver d) {
		e = d.findElement(By.name("login"));
		return e;
	}
}
