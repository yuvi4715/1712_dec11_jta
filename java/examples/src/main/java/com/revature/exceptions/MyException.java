package com.revature.exceptions;

public class MyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "This is an intentional exception thrown by myself";
	}
}
