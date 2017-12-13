package com.revature.assignment1.exceptions;

public class Q12 {

	public static void main(String[] args) {

		try {
			System.out.println("Starting try block");
			
			for (int i = 0; i < 10; i++) {
				if (i == 5) {
					throw new Q10_LoopCounterEqualsFiveException();
				}
			}
			
			System.out.println("Ending try block");
		}
		catch (Q10_LoopCounterEqualsFiveException customException) {
			System.out.println("Starting catch block");
			
			System.out.println(customException.getMessage());
			
			System.out.println("Ending catch block");
		}
	}
}
