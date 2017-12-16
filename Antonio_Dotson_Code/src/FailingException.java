// Antonio Dotson
public class FailingException extends Exception{

	/**
	 * custom message for an exception
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		return "This is an intentional exception thrown by myself";
	}
}
   