package exceptions;

public class CustomExceptionThrower15 {
	/*
	 * 15. Use the System.exit(0) command in the try block and 
	 * rerun the application. Note the console output to see 
	 * if the finally block executes
	 */
	public static void main(String[] args) {
		try {
			System.exit(0);
			someMethod();
		} catch (CustomException10 e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("Starting finally block");
			System.out.println("Goodbye...");
		}
	}
	
	private static void someMethod() throws CustomException10 {
		throw new CustomException10();
	}
}
