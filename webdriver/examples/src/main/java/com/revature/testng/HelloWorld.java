package com.revature.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class HelloWorld {
  @Test(dataProvider = "mydata")
  public void f(Integer n, String s) {
	  System.out.println("value of n: " + n + ", value of s: " + s);
  }
  
  @Test
  public void anotherTest() {
	System.out.println("another test");  
  }
  
  @BeforeMethod
  public void beforeMethodreally() {
	  System.out.println("before method");
  }

  @AfterMethod
  public void afterMethodIdontlikethisname() {
	  System.out.println("after method");
  }

  @DataProvider
  public Object[][] mydata() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("after suite method");
  }

}
