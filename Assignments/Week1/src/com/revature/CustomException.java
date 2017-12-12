package com.revature;


@SuppressWarnings("serial")
public class CustomException extends Exception {
	public CustomException(Throwable newThrowable) {
		super(newThrowable);
	}
	
	public CustomException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}

	public CustomException(String message, Throwable newThrowable) {
		super(message,newThrowable);
	}
	
	public String getMessage() {
		//this overrides the java.lang.Exception.getMessage()
		return "These numbers are not divisible";
	}
}
