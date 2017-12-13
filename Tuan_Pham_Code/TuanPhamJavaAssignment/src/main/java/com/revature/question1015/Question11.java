package com.revature.question1015;

public class Question11 {
	
	// Ducking the exception
	public void myError() throws Question10 {
	}
	
	// Print statements to view the contro flow
	public void testError() {
		System.out.println("Starting try block");
		try {
			// System.exit(0) stops the code so finally doesn't run
			System.exit(0);
			// Throws my custom exception type
			throw new Question10();
		} 
		catch(Exception e) {
			System.out.println("Ending try block");
			e.getMessage();
		// Finally block that will always run	
		} finally {
			System.out.println("Goodbye");
		}
	}
	
	public static void main(String[] args) {
		new Question11().testError();
	}
}
