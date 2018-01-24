package com.revature.testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.sql.SQLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class HelloWorld {
//  @Test(dataProvider = "mydata")
  public void f(Integer n, String s) {
	  System.out.println("value of n: " + n + ", value of s: " + s);
  }
  
  @Test (groups ="iteration1")
  public void anotherTest() {
	System.out.println("another test");  
  }
  
	@Test(priority=-1, groups ="iteration2")
	void hello2() {
		System.out.println("hello2");
	}
	
	@Test(priority=1, groups ="iteration1")
	void hello1() {
		System.out.println("hello1");
	}

	@Test(priority=1, timeOut=1000, expectedExceptions= {ArithmeticException.class,SQLException.class}, groups ="iteration2")
	void hello3() {
		for(int i=0; i <100; i++) {
			System.out.println("hello3" + (i/0));
			
		}
	}  
	
	
  
  //@BeforeMethod
  public void beforeMethodreally() {
	  System.out.println("before method");
  }

//  @AfterMethod
  public void afterMethodIdontlikethisname() {
	  System.out.println("after method");
  }

 // @DataProvider
  public Object[][] mydata() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
 // @BeforeClass
  public void beforeClass() {
	  System.out.println("before class");
  }

 // @AfterClass
  public void afterClass() {
	  System.out.println("after class");
  }

  //@BeforeTest
  public void beforeTest() {
	  System.out.println("before test");
  }

  //@AfterTest
  public void afterTest() {
	  System.out.println("after test");
  }

  //@BeforeSuite
  public void beforeSuite() {
	  System.out.println("before suite");
  }

 // @AfterSuite
  public void afterSuite() {
	  System.out.println("after suite method");
  }

}
