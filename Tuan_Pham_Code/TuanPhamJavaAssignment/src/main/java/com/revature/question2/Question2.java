package com.revature.question2;

//2.	Write a program to search for the greatest of three numbers using Short-circuit Operators and print the result. 
public class Question2 {

	public static int greatestOfThree(int a, int b, int c) {
		// Assign the first number as the greatest number by default
		int greatest = a;
		
		// Compare if the second number is greater than the first and third number
		// If it is greater than the two, the second number will be the new greatest number
		if (b >= a && b >= c) {
			greatest = b;
		}
		// Compare if the third number is greater than the first and second number
		// If it is greater than the two, the third number will be the new greatest number
		else if (c >= a && c >= b) {
			greatest = c;
		}
		return greatest;
		
		//If the second and third number is not greater than the first, the first was already the greatest number
	}
	public static void main(String[] args) {
		// Choose three numbers to check which is the greatest
		
		int first = -6;
		int second = -1;
		int third = -3;
		
		System.out.println("Out of " + first + ", " + second + ", and " + third + ",  " 
		+ greatestOfThree(first, second, third) + " is the greatest of them all.");

	}

}
