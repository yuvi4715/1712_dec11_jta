package com.revature.assignment1.exceptions;

public class Q13 {

	public static void main(String[] args) throws Q10_LoopCounterEqualsFiveException {

		for (int i = 0; i < 10; i++) {
			if (i == 5) {
				throw new Q10_LoopCounterEqualsFiveException();
			}
		}
	}
}
