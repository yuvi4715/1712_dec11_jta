package com.revature.assignment1;

public class Question5B {

	public static void main(String[] args) {
		int firstNumber = 10;
		int secondNumber = 5;
		
		// Create an instance of the first class that contains the methods 
		Question5A firstClass = new Question5A();
		
		// Call the class with the methods to compute and print out the results
		System.out.println("The two numbers are " + firstNumber + " and " + secondNumber);
		System.out.println(firstNumber + " + " + secondNumber + " = " + firstClass.sum(firstNumber, secondNumber));
		System.out.println(firstNumber + " - " + secondNumber + " = " + firstClass.difference(firstNumber, secondNumber));
		System.out.println(firstNumber + " * " + secondNumber + " = " + firstClass.product(firstNumber, secondNumber));
		System.out.println(firstNumber + " / " + secondNumber + " = " + firstClass.quotient(firstNumber, secondNumber));

	}

}
