package com.revature.webdriver;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTours {
	static WebDriver wd = null;
	public static void main(String[] args) {
//		openApp();
//		login(null, null);
//		findFlights();
//		selectFlight();
//		logout();
//		closeApp();
	}
	
	public static void openApp(String url) {
		File f1 = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", f1.getAbsolutePath());
		wd = new ChromeDriver();
		wd.get(url);
	}
	
	public static void login(String user, String pass) {
		wd.findElement(By.name("userName")).sendKeys(user);
		wd.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(pass);
		wd.findElement(By.name("login")).submit();
		//wd.findElement(By.id("lst-ib")).sendKeys(Keys.RETURN);
	}
	
	static void findFlights() {
		wd.findElement(By.xpath("//select[@name=\"toPort\"]")).sendKeys("Frankfurt");
		wd.findElement(By.name("findFlights")).submit();
	}
	
	static void selectFlight() {
		wd.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/p/input")).submit();
	}
	
	static void logout() {
		wd.findElement(By.xpath("//a[@href=\"mercurysignoff.php\"]")).click();
	}
	
	static void closeApp(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wd.quit();		
	}

}
