package exceptions;

public class CustomExceptionThrower13_14 {
	/*
	 * 13. Duck the exception at least once
	 * 14. Implement a finally block that prints a graceful goodbye message
	 */
	public static void main(String[] args) {
		try {
			System.out.println("Starting try block");
			someMethod();
		} catch (CustomException10 e) {
			System.out.println("Starting catch block");
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
