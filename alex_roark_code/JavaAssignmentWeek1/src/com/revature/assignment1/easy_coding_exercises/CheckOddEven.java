package com.revature.assignment1.easy_coding_exercises;

public class CheckOddEven {

	public static void main(String[] args) {

		int number = 10;
		if (number % 2 != 0) {
			isOdd();
		} else {
			isEven();
		}
	}
	
	private static void isOdd() {
		System.out.println("Odd Number");
	}
	
	private static void isEven() {
		System.out.println("Even Number");
	}

}
