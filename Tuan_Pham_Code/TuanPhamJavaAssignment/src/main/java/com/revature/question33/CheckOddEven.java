package com.revature.question33;

// Write a program called CheckOddEven which prints "Odd Number" if the int variable “number” is odd, or “Even Number” otherwise. Hint: you may use modulus operator.
public class CheckOddEven {
	
	public void check(int number) {
		// If the number is divided by 2 has remainder = 0, it is even; including 0
		if (number % 2 == 0) {
			System.out.println("Even Number");
		// If number divided by 2 has a remainder other than 0, it is odd
		} else {
			System.out.println("Odd Number");
		}
	}
	public static void main(String[] args) {
		new CheckOddEven().check(100);
	}

}
