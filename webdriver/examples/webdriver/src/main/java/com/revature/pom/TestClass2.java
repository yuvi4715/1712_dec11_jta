package com.revature.pom;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass2 {
	static WebDriver wd = null;
	
	@BeforeSuite(groups="iteration1")
	private static void openApplication() {
		File f1 = new File("src/main/resources/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", f1.getAbsolutePath());
		wd = new ChromeDriver();
	}

	@BeforeTest(groups="iteration1")
	void login() {
		wd.get("http://newtours.demoaut.com");
		LoginPage.user(wd).sendKeys("yuvi1");
		LoginPage.password(wd).sendKeys("yuvi1");
		LoginPage.signin(wd).submit();
	}
	
	//@Ignore
	@Test(priority=0, enabled=true, groups ="iteration1")
	void verifyLogin() {
		String s1 = wd.findElement(By.xpath("//a[@href=\"mercurysignoff.php\"]")).getText();
		assertEquals(s1, "SIGN-OFF");
	}
	
	@Test(enabled = true, priority=1, groups ="iteration2")
	private static void navigateToFlightFinder() {
		FlightFinder.tripType(wd).click();
		FlightFinder.departFrom(wd).sendKeys("Paris");
		FlightFinder.arriveTo(wd).sendKeys("Frankfurt");
		FlightFinder.airline(wd).sendKeys("No Preference");
		FlightFinder.findFlightsButton(wd).click();
	}
	
	@AfterTest(groups="iteration1")
	void logout() {
		Logout.signoff(wd).click();
	}
	
	@AfterSuite(groups="iteration1")
	void closeApp(){
		wd.quit();
	}
}
