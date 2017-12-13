package com.revature.assignment1.core_java;

public class Q2 {

	public static void main(String[] args) {

		int number1 = 3;
		int number2 = 6;
		int number3 = 9;

		int greatestNumber = 0;
		if (number1 > number2 && number1 > number3) {
			greatestNumber = number1;
		} else if (number2 > number3) {
			greatestNumber = number2;
		} else {
			greatestNumber = number3;
		}

		System.out.println("The greatest number is " + greatestNumber);
	}

}
