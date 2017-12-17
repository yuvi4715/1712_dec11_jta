package com.revature.syntax;

//Nathan Poole
//Questoin Four
//Write a program to add, subtract, multiply 
//	and divide two numbers using methods with 
//	parameters using only one class.

public class QuestionFour {

	static int addition(int a, int b) {
		return a+b;
	}
	
	static int subtraction(int a, int b) {
		return a-b;
	}
	
	static int multiplication(int a, int b) {
		return a*b;
	}
	
	static double division(int a, int b) {
		return (double)a/b;
	}
	
	public static void main(String[] args) {
		int num1 = 3, num2 = 7;
		System.out.println(addition(num1, num2));
		System.out.println(subtraction(num1, num2));
		System.out.println(multiplication(num1, num2));
		System.out.println(division(num1, num2));
	}
}
