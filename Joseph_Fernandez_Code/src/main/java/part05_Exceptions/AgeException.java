package part05_Exceptions;

public class AgeException extends Exception {

	public AgeException() {
		super();
	}
	
	public AgeException(String msg) {
		super(msg);
	}
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
