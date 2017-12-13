package com.revature.assignment1.advanced_concepts;

public class Q18 {

	public static void main(String[] args) {

		String number1 = "22";
		String number2 = "44";
		
		numbersFromStringsAdder(number1, number2);
	}
	
	private static void numbersFromStringsAdder(String number1, String number2) {
		int number1AsInt = Integer.parseInt(number1);
		int number2AsInt = Integer.parseInt(number2);
		
		int result = number1AsInt + number2AsInt;
		System.out.println(result);
	}

}
