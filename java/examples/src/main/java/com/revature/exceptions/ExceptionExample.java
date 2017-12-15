package com.revature.exceptions;

public class ExceptionExample {

	ExceptionExample ee = null;

	public int divideByZero(int x, int y) {
		return x / y;
	}

	public void printObject() {
		System.out.println(ee.toString());
	}

}
