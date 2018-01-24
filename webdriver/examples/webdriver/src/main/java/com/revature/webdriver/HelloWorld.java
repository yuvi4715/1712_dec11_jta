package com.revature.webdriver;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorld {

	public static void main(String[] args) {
		chromeOpenApp();
		//firefoxOpenApp();
	}

	static void chromeOpenApp() {
		File f1 = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", f1.getAbsolutePath());
		WebDriver wd = new ChromeDriver();
		wd.get("http://www.google.com");
		//wd.close();
		wd.findElement(By.id("lst-ib"));
		wd.findElement(By.id("lst-ib")).sendKeys("SDET");
		wd.findElement(By.id("lst-ib")).sendKeys(Keys.RETURN);
		
		String s = wd.getTitle();
		System.out.println(s);
		wd.quit();
	}
	
	static void firefoxOpenApp() {
		File f1 = new File("src/main/resources/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", f1.getAbsolutePath());
		WebDriver wd = new FirefoxDriver();
		wd.get("http://www.google.com");
		//wd.close();
		wd.quit();
	}
}

