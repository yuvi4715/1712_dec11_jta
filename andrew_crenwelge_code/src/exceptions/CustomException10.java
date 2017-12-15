package exceptions;

public class CustomException10 extends Exception {
	/*
	 * Create a custom exception class that overrides the getMessage() method
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "This is a custom exception";
	}
}
