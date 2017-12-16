package com.revature.week1.Exceptions;

public class Exit {

	public static void main(String[] args) {

		try {
			//The finally does not print
			System.exit(0);
			int problem = 50 / 0;

		} catch (ArithmeticException e) {

		} finally {

			System.out.println("This is a good exception message");

		}
	}

}
