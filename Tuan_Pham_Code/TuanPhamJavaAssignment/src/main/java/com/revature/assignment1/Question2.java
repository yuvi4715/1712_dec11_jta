package com.revature.assignment1;

//2.	Write a program to search for the greatest of three numbers using Short-circuit Operators and print the result. 
public class Question2 {

	public static int greatestOfThree(int a, int b, int c) {
		int greatest = a;
		
		if (b >= a && b >= c) {
			greatest = b;
		}
		else if (c >= a && c >= b) {
			greatest = c;
		}
		return greatest;
	}
	public static void main(String[] args) {
		int first = -6;
		int second = -1;
		int third = -3;
		
		System.out.println("Out of " + first + ", " + second + ", and " + third + ",  " 
		+ greatestOfThree(first, second, third) + " is the greatest of them all.");

	}

}
