package com.revature.question46;

// Write a method that swaps two integer variables without using a third variable.
public class intSwap {

	public static void swap(int a, int b) {
		System.out.println("First number is " + a + " and second number is " + b);
		System.out.println("Swapping numbers");
		// First,add the two numbers to get a sum 
		a = a + b;
		// To get first number, reverse the addition and assign to second variable
		b = a - b;
		// Now that the second variable is the first number, subtract the sum with the new second number to get original second number
		a = a - b;
		System.out.println("First number is " + a + " and second number is " + b);
		
	}
	public static void main(String[] args) {
		// Choose two random numbers to swap
		swap(12, 7);
	}
}
