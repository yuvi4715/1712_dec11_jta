package com.revature.pom;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {
	static WebDriver wd = null;
	
	public static void main(String[] args) {
		openApplication();
		testMethod();
	}

	private static void openApplication() {
		File f1 = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", f1.getAbsolutePath());
		wd = new ChromeDriver();
		wd.get("http://newtours.demoaut.com");
	}

	private static void testMethod() {
		//HomePage.home(wd).click();
		//HomePage.flights(wd).click();
		//HomePage.hotels(wd).click();
		//HomePage.cruises(wd).click();
		
		//HomePage.home(wd).click();
		LoginPage.user(wd).sendKeys("yuvi1");
		LoginPage.password(wd).sendKeys("yuvi1");
		LoginPage.signin(wd).submit();
		
		FlightFinder.tripType(wd).click();
		FlightFinder.departFrom(wd).sendKeys("Paris");
		FlightFinder.arriveTo(wd).sendKeys("Frankfurt");
		FlightFinder.airline(wd).sendKeys("No Preference");
		FlightFinder.findFlightsButton(wd).click();
		Logout.signoff(wd).click();
		wd.quit();
	}
}
