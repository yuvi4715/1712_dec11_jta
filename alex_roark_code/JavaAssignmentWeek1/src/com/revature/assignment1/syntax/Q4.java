package com.revature.assignment1.syntax;

public class Q4 {
	
	static int numbersAdded;
	static int numbersSubtracted;
	static int numbersMultiplied;
	static float numbersDivided;

	public static void main(String[] args) {
		
		int number1 = 23;
		int number2 = 9;

		add(number1, number2);
		subtract(number1, number2);
		multiply(number1, number2);
		divide(number1, number2);
		
		System.out.println(number1 + " and " + number2 + " added is " + numbersAdded);
		System.out.println(number1 + " and " + number2 + " subtracted is " + numbersSubtracted);
		System.out.println(number1 + " and " + number2 + " multiplied is " + numbersMultiplied);
		System.out.println(number1 + " and " + number2 + " divided is " + numbersDivided);
	}
	
	private static void add(int number1, int number2) {
		numbersAdded = number1 + number2;
	}
	
	private static void subtract(int number1, int number2) {
		numbersSubtracted = number1 - number2;
	}
	
	private static void multiply(int number1, int number2) {
		numbersMultiplied = number1 * number2;
	}
	
	private static void divide(float number1, float number2) {
		numbersDivided = number1 / number2;
	}

}
