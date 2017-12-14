package com.revature.exceptions;

import org.apache.log4j.Logger;

public class MainClass {

	final static Logger logger = Logger.getLogger(Logger.class);
	public static void main(String[] args) throws MyException, Exception {
		testMyOwnException();
	}
	
	public static void testMyOwnException() throws MyException {
		logger.info("my custom exception is thrown");
		throw new MyException();
	}
	
	public void myMethod(){
		try {
			//new ExceptionExample().divideByZero(10, 0);
			new ExceptionExample().printObject();
		}
		catch(ArrayIndexOutOfBoundsException a) {
			a.printStackTrace();
		}
		catch (ArithmeticException | ClassCastException ar) {
			System.out.println("may be the right exception is caught this time");
			System.out.println(ar.getMessage());
			logger.trace(ar.getMessage());
			logger.info(ar.getMessage());
			logger.warn(ar.getMessage());
			logger.fatal(ar.getMessage());
		}
		catch(Exception e) {
			System.out.println("exception caught!!!");
			logger.trace(e.getMessage());
			logger.info(e.getMessage());
			logger.warn(e.getMessage());
			logger.fatal(e.getMessage());
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
		finally {
			System.out.println("no matter what happens before me, I always execute");
		}		
	}
}
