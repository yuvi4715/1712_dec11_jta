package exceptions;

public class CustomExceptionThrower11_12 {
	/*
	 * 11. Create a class that manually throws an exception of your custom type
	 * 
	 * 12. Use System.out.println( ) to note where you are in 
	 * the control flow. Example: “Starting try block”, 
	 * “Ending try block”, “Starting catch block”, etc.
	 */
	public static void main(String[] args) {
		someMethod();
	}
	
	private static void someMethod() {
		try {
			System.out.println("Starting try block");
			throw new CustomException10();
		}
		catch(CustomException10 e) {
			System.out.println("Starting catch block");
			e.printStackTrace();
		}
	}

}
