package com.revature.junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/*
* The assert library is used to determine the state of a test.
* With it you can either fail or pass tests.
* -assertEqauls ->Determine if actual result equals expected result.
* -assertTrue -> Pass if expected boolean is true
* -assertFalse
* @Ignore is used to skip a test entirely. 
* A Java annotation is a tag used for metadata that can help
* provide useful rules and guidelines for an underlying method
*/

public class TestCalci {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Before ");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("After ");
	}

	@Test
	public void testAdd() {
		System.out.println("test for add");
		assertEquals(30, new CalculatorImplementation().add(10, 20));
		assertEquals(40, new CalculatorImplementation().add(20, 20));
		assertEquals(50, new CalculatorImplementation().add(30, 20));
		//bad practise to have more than one test in on test method
	}

	@Test
	public void testSub() {
		System.out.println("test for sub");;
	}

	@Ignore
	@Test
	public void testDivide() {
	}

	@Ignore
	@Test
	public void testMultiply() {
	}

}
