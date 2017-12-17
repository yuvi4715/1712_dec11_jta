package Exceptions; // this class contains the code for number 10

public class customException extends Exception{
	
	private static final long serialVersionUID = -1843701894867586446L; // creates a serialVersionUID

	@Override // override the getMessage() method
	public String getMessage() {
		return "This is my overriden getMessage() method";
		
	}
	
}
