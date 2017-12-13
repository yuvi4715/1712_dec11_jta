package com.revature.assignment1.easy_coding_exercises;

import java.util.Scanner;

public class Arithmetic {

	public static void main(String[] args) {

		int operand1;
		int operand2;
		String operator;
		int result = 0;
		
		Scanner keyboardScanner = new Scanner(System.in);
		
		System.out.println("Please enter integer 1:");
		operand1 = keyboardScanner.nextInt();
		keyboardScanner.nextLine();
		
		System.out.println("Please enter integer 2:");
		operand2 = keyboardScanner.nextInt();
		keyboardScanner.nextLine();
		
		System.out.println("Please enter arithmetic operator:");
		operator = keyboardScanner.nextLine();
		
		keyboardScanner.close();
		
		if (operator.equals("+")) {
			result = operand1 + operand2;
		} else if (operator.equals("-")) {
			result = operand1 - operand2;
		} else if (operator.equals("*")) {
			result = operand1 * operand2;
		} else if (operator.equals("/")) {
			result = operand1 / operand2;
		}
		
		System.out.println("The result is:\n");
		System.out.println(result);
	}

}
