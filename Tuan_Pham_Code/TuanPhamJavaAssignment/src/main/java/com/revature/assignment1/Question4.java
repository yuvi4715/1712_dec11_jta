package com.revature.assignment1;

//4.	Write a program to add, subtract, multiply and divide two numbers using methods with parameters using only one class.
public class Question4 {

	static int firstNumber = 8;
	static int secondNumber = 4;
	
	// This method adds the two parameters
	public static int sum(int first, int second) {
		return first + second;
	}
	
	// This method subtracts the two parameters
	public static int difference(int first, int second) {
		return first - second;
	}
	
	// This method multiplies the two parameters
	public static int product(int first, int second) {
		return first * second;
	}
	
	// This method divides the two parameters
	public static int quotient(int first, int second) {
		return first / second;
	}
	
	public static void main(String[] args) {
		System.out.println("The two numbers are " + firstNumber + " and " + secondNumber);
		System.out.println(firstNumber + " + " + secondNumber + " = " + sum(firstNumber, secondNumber));
		System.out.println(firstNumber + " - " + secondNumber + " = " + difference(firstNumber, secondNumber));
		System.out.println(firstNumber + " * " + secondNumber + " = " + product(firstNumber, secondNumber));
		System.out.println(firstNumber + " / " + secondNumber + " = " + quotient(firstNumber, secondNumber));
	}
}
