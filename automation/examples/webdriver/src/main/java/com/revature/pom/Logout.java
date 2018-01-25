package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Logout {

	static WebElement e = null;

	public static WebElement signoff(WebDriver d) {
		e = d.findElement(By.xpath("//a[@href=\"mercurysignoff.php\"]"));
		return e;
	}
}
