package com.revature.assignment1.syntax;

public class Q5P1_Main {

	public static void main(String[] args) {

		int number1 = 23;
		int number2 = 9;

		int numbersAdded = Q5P2_Math.add(number1, number2);
		int numbersSubtracted = Q5P2_Math.subtract(number1, number2);
		int numbersMultiplied = Q5P2_Math.multiply(number1, number2);
		float numbersDivided = Q5P2_Math.divide(number1, number2);
		
		System.out.println(number1 + " and " + number2 + " added is " + numbersAdded);
		System.out.println(number1 + " and " + number2 + " subtracted is " + numbersSubtracted);
		System.out.println(number1 + " and " + number2 + " multiplied is " + numbersMultiplied);
		System.out.println(number1 + " and " + number2 + " divided is " + numbersDivided);
	}

}
