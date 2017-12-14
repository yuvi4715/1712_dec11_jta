package com.revature.week1_jason_shen;

//10. Create a custom exception class that overrides the getMessage( ) method
public class MyCustomException extends Exception {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "My custom exception was thrown!";
	}
			
}
	