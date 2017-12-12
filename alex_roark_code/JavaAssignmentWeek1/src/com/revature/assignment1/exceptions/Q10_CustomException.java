package com.revature.assignment1.exceptions;

public class Q10_CustomException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;

	public Q10_CustomException() {}

	public Q10_CustomException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return "The following custom exception has occurred:\n" + message;
	}

}
