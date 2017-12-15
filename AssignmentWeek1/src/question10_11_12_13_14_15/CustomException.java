package question10_11_12_13_14_15;

@SuppressWarnings("serial")
public class CustomException extends Exception {
	public String getMessage() {
		return "This is just a custom exception.";
	}
}
