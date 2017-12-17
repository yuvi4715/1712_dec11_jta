package com.revature.ece;

/*
 * Nathan Poole
 * Qusetion Thirty-three
 * Write a program called CheckOddEven which prints "Odd Number" if the int 
 * 		variable “number” is odd, or “Even Number” otherwise. Hint: you may 
 * 		use modulus operator.
 */

public class CheckOddEven {

	public static void main(String[] args) {
		checkOddEven(1);
		checkOddEven(2);
	}

	private static void checkOddEven(int number) {
		if((number%2) > 0) System.out.println("Odd Number");
		else System.out.println("Even Number");
	}
}
