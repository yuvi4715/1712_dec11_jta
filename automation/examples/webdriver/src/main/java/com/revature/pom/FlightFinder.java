package com.revature.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightFinder {
	static WebElement e =null;
	public static WebElement tripType(WebDriver d) {
		e = d.findElement(By.xpath("//input[@value=\"oneway\"]"));
		return e;
	}
	public static WebElement departFrom(WebDriver d) {
		e = d.findElement(By.name("fromPort"));
		return e;
	}
	public static WebElement arriveTo(WebDriver d) {
		e = d.findElement(By.name("toPort"));
		return e;
	}
	public static WebElement airline(WebDriver d) {
		e = d.findElement(By.name("airline"));
		return e;
	}
	public static WebElement findFlightsButton(WebDriver d) {
		e = d.findElement(By.name("findFlights"));
		return e;
	}
}
