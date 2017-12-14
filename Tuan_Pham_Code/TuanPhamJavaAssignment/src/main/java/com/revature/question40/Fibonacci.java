package com.revature.question40;

// Write a Java program to print the first 100 Fibonacci numbers using iteration. Rewrite using recursion.
public class Fibonacci {
	
	public static void iterativeFib() {
		double start = 0;
		double sum = 1;
		System.out.println("Printing Fibonacci numbers iteratively");
		System.out.printf("%.0f", start);
		System.out.print(" ");

		// Using a for loop to computer iteratively
		for (int i = 0; i < 100; i++) {
			// Print double without decimal point
			System.out.printf("%.0f", sum);
			System.out.print(" ");
			
			// Create a temp variable to act as a pointer to store previous number
			double temp = sum;
			
			// Sum the first number and the following number each time
			sum += start;
			// Replace the following number as the new previous number
			start = temp;
		}
	}
	
	public static double recursiveFib(int n) {
		// Base case to terminate recursive function
		if (n == 0) {
			return 0;
		// Second base case to terminate recursive function
		} else if (n == 1) {
			return 1;
		// Call recursively to sum previous two numbers
		} else
			return recursiveFib(n - 1) + recursiveFib(n - 2);
	}
	
	public static void printRecursiveFib() {
		System.out.println("\nPrinting Fibonacci numbers in recursive");
		
		// Print out the Fibonacci numbers with removing the decimal point from double for formatting
		for (int i = 0; i < 100; i++) {
			System.out.printf("%.0f", recursiveFib(i));
			System.out.print(" ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		iterativeFib();
		printRecursiveFib();
	}

}
