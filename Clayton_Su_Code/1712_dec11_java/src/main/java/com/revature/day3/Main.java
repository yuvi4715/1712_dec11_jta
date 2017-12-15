package com.revature.day3;

import org.apache.log4j.Logger;

public class Main {

	final static Logger logger = Logger.getLogger(Logger.class);

	public static void testMyOwnException() throws MyException
	{
		//Logger.info("my custom exception is thrown");
		throw new MyException();
	}
	
	public static void main(String[] args) {
		try {
			// new ExceptionExample().divideByZero(10, 0);
			new ExceptionExample().printObject();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} catch (ArithmeticException | ClassCastException ar) {
			System.out.println("maybe right exceptions");
			System.out.println(ar.getMessage());
		} catch (Exception e) {
			System.out.println("exception caught");
		}
	}

}
