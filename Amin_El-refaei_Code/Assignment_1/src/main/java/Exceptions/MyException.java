package Exceptions; // this class contains the code for numbers 11-15

public class MyException extends Exception {

	private static final long serialVersionUID = 1L; // creates a serialVersionUID

	public String getMessage() { 
		return "I am intentionally throwing this exception";
	}

	public static void main(String[] args) {

		System.out.println("I am now starting the try block");
		try {
			new customException().getMessage(); // calling getMessage() method
			//System.exit(0); // if System.exit(0); is executed, everything after that line will not get executed
		} catch (ArithmeticException arithException) { // catch arithmetic exception
			System.out.println("I am hoping that this is the correct exception to be caught");
			System.out.println(arithException.getMessage());
			System.out.println("Ending the catch block");
		} finally {
			System.out.println("Now exiting the try-catch-finally block. Goodbye"); // the finally block will always execute no matter what
		}
	}

}
