package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	static WebElement e =null;
	
	public static WebElement home(WebDriver d) {
		e = d.findElement(By.xpath("//a[@href=\"mercurywelcome.php\"]"));
		return e;
	}
	
	public static WebElement flights(WebDriver d) {
		e = d.findElement(By.xpath("//a[@href=\"mercuryreservation.php\"]"));
		return e;
	}
	
	public static WebElement hotels(WebDriver d) {
		e = d.findElement(By.xpath("//a[@href=\"mercuryunderconst.php\"]"));
		return e;
	}
	
	public static WebElement cruises(WebDriver d) {
		e = d.findElement(By.xpath("//a[@href=\"mercurycruise.php\"]"));
		return e;
	}

}
