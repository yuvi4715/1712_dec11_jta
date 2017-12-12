package com.revature.assignment1.exceptions;

public class Q11_ExceptionThrower {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			try {
				if (i == 5) {
					throw new Q10_CustomException("Loop counter equals 5!");
				}
			}
			catch (Q10_CustomException customException) {
				System.out.println(customException.getMessage());
			}
		}
	}
}
