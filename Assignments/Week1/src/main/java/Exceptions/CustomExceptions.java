package Exceptions;

public class CustomExceptions extends Exception{
	
	private static String error;
	
	public CustomExceptions(String message) {
		super(message);
		error = message;

	}
	
	public CustomExceptions(String message, Throwable newThrowable) {
		super(message, newThrowable);
		error = message;

	}
	
	public CustomExceptions(Throwable newThrowable) {
		super(newThrowable);

	}
	
	public String getMessage() {
		return error;
	}
	
	public StackTraceElement[]  getStackTrace() {
		return null;
	}
	
	

}
