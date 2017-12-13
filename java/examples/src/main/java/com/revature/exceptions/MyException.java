package com.revature.exceptions;

public class MyException extends Exception {

	public String getMessage() {
		return "This is an intentional exception thrown by myself";
	}
}
