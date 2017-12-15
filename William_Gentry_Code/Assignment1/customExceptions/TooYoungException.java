package customExceptions;

public class TooYoungException extends Exception{
	
	public TooYoungException() {
		super();
	}
	
	public TooYoungException(String msg) {
		super(msg);
	}
	
	public String getMessage() {
		return super.getMessage();
	}
}
