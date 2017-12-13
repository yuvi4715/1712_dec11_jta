package com.revature.assignment1;

//1.	Write a program to add, subtract, multiply and divide two non-zero hard-coded numbers.
public class Question1 {

	//Two hard coded Numbers
	static int firstNumber = 6;
	static int secondNumber = 3;
	
	public static void main(String[] args) {
		System.out.println("The two numbers are " + firstNumber + " and " + secondNumber);
		// Adding the two numbers and printing the result
		System.out.println(firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber));
		// Subtracting the two numbers and printing the result
		System.out.println(firstNumber + " - " + secondNumber + " = " + (firstNumber - secondNumber));
		// Multiplying the two numbers and printing the result
		System.out.println(firstNumber + " * " + secondNumber + " = " + (firstNumber * secondNumber));
		// Dividing the two numbers and printing the result
		System.out.println(firstNumber + " / " + secondNumber + " = " + (firstNumber / secondNumber));
	}
}
