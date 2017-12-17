package com.revature.exceptions;

/*
 * Nathan Poole
 * Question Ten
 * Create a custom exception class that overrides the getMessage( ) method
 */

public class QuestionTen extends Exception{

	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "It didn't work I guess";
	}
}
