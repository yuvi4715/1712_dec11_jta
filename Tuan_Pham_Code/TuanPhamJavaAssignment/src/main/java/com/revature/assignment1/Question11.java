package com.revature.assignment1;

public class Question11 {
	
	
	public void myError() throws Question10 {
	}
	
	public void testError() {
		System.out.println("Starting try block");
		try {
			System.exit(0);
			throw new Question10();
		} 
		catch(Exception e) {
			System.out.println("Ending try block");
			e.getMessage();
		} finally {
			System.out.println("Goodbye");
		}
	}
	
	public static void main(String[] args) {
		Question11 q = new Question11();
				q.testError();
	}
}
