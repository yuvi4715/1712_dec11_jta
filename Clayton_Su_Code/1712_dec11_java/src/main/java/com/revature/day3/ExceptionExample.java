package com.revature.day3;

public class ExceptionExample {
	
	ExceptionExample ee = null;
	
	int divideByZero(int x, int y)
	{
		return x /y;
	}
	
	public void printObject()
	{
		System.out.println(ee.toString());
	}
}
