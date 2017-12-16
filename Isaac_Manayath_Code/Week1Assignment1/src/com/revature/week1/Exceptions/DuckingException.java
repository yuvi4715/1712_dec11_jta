package com.revature.week1.Exceptions;

public class DuckingException {
	/*  Not Handled Check Type Exception  */
	public static void main(String[] args) throws ClassNotFoundException {
		test1();
	}

	/* ExlicityDucking */
	private static void test1() throws ClassNotFoundException {
		Class.forName("");
	}
}

