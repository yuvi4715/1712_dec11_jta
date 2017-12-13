package com.revature.assignment1.exceptions;

public class Q11_LoopCounterEqualsFiveExceptionThrower {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			try {
				if (i == 5) {
					throw new Q10_LoopCounterEqualsFiveException();
				}
			}
			catch (Q10_LoopCounterEqualsFiveException customException) {
				System.out.println(customException.getMessage());
			}
		}
	}
}
