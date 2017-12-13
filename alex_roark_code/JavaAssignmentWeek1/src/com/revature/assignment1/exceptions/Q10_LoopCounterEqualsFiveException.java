package com.revature.assignment1.exceptions;

public class Q10_LoopCounterEqualsFiveException extends Exception {

	private static final long serialVersionUID = 1L;

	public Q10_LoopCounterEqualsFiveException() {}

	@Override
	public String getMessage() {
		return "Loop counter equals 5!";
	}

}
