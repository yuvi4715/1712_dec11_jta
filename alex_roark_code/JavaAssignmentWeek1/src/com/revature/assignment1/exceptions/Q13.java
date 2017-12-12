package com.revature.assignment1.exceptions;

public class Q13 {

	public static void main(String[] args) {

		try {
			System.out.println("Starting try block");
			
			for (int i = 0; i < 10; i++) {
				if (i == 20) {
					throw new Q10_CustomException("Loop counter equals 20!");
				}
			}
			
			System.out.println("Ending try block");
		}
		catch (Q10_CustomException customException) {
			System.out.println("Starting catch block");
			
			System.out.println(customException.getMessage());
			
			System.out.println("Ending catch block");
		}
	}
}
