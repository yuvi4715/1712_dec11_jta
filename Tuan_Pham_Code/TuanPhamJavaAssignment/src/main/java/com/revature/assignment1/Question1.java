package com.revature.assignment1;

//1.	Write a program to add, subtract, multiply and divide two non-zero hard-coded numbers.
public class Question1 {

	static int firstNumber = 6;
	static int secondNumber = 3;
	
	public static void main(String[] args) {
		System.out.println("The two numbers are " + firstNumber + " and " + secondNumber);
		System.out.println(firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber));
		System.out.println(firstNumber + " - " + secondNumber + " = " + (firstNumber - secondNumber));
		System.out.println(firstNumber + " * " + secondNumber + " = " + (firstNumber * secondNumber));
		System.out.println(firstNumber + " / " + secondNumber + " = " + (firstNumber / secondNumber));
	}
}
