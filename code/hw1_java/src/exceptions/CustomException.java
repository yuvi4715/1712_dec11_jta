package exceptions;

public class CustomException extends Exception { //#10
	public String getMessage() {
		return "Custom Exception message!";
	}
}