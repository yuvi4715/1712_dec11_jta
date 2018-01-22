package com.revature.webdriver;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours {

	static WebDriver wd = null;
	public static void main(String[] args) {
		openApp();
		login();
		//closeApp();
	}
	
	static void openApp() {
		File f1 = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", f1.getAbsolutePath());
		wd = new ChromeDriver();
		wd.get("http://newtours.demoaut.com");
	}
	
	static void login() {
		wd.findElement(By.name("userName")).sendKeys("yuvi1");
		wd.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("yuvi1");
		wd.findElement(By.name("login")).submit();
		//wd.findElement(By.id("lst-ib")).sendKeys(Keys.RETURN);
	}
	static void closeApp(){
		wd.quit();		
	}

}
