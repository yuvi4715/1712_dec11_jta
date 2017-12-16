package getasew.assignment1.exceptions;

public class AlarmMissingException extends Exception {
	
	public String getMessage() {
		return "You're missing the alarm";
	}

}