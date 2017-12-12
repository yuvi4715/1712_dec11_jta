package com.revature.assignment1.exceptions;

public class Q10_CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "An Exception has occurred!";
	}

}
