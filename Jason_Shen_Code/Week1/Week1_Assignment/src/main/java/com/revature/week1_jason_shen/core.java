// Revature JTA Week 1 Assignment
// Jason Shen

package com.revature.week1_jason_shen;

// ==== Core Java ====

public class core {
	
	public static void question1() {
	// 1. Write a program to add, subtract, multiply and divide two non-zero hard-coded numbers.
		
		// Hard coded numbers
		int x = 24;
		int y = 4;
		
		// Computations
		int sum = x + y;
		int diff = x - y;
		int prod = x * y;
		int quot = x / y;
		
		System.out.println("1. Hard Coded: " + x + " " + y);
		System.out.println("Sum: " + sum);
		System.out.println("Difference: " + diff);
		System.out.println("Product: " + prod);
		System.out.println("Quotient: " + quot);
	}
	
	public static void main(String args[]) {
	
		question1();
	
	}
	
}
