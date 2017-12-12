// Revature JTA Week 1 Assignment
// Jason Shen

package com.revature.week1_jason_shen;

// ==== Core Java ====

public class core {
	
	static void basic_ops() {
	// 1. Write a program to add, subtract, multiply and divide two non-zero hard-coded numbers.
		
		// Hard coded numbers
		int x = 24;
		int y = 4;
		
		// Computations
		int sum = x + y;
		int diff = x - y;
		int prod = x * y;
		int quot = x / y;
		
		System.out.println("Question 1: ");
		System.out.println("-----");
		System.out.println("Hard Coded: " + x + " " + y);
		System.out.println("Sum: " + sum);
		System.out.println("Difference: " + diff);
		System.out.println("Product: " + prod);
		System.out.println("Quotient: " + quot);
		System.out.println();
		
		return;
	}
	
	static int find_greatest(int x, int y, int z) {
	// 2. Write a program to search for the greatest of three numbers using Short-circuit Operators and print the result. 
		
		// Short circuit operators == ternary operators?
		
		// A number is the greatest iff greater than all other numbers
		// Both comparison statements within a clause should be true to find the greatest number
		int greatest = (x > y) && (x > z) ? x : (y > x) && (y > z) ? y : z;
		
		System.out.println("Question 2: ");
		System.out.println("-----");
		System.out.println("Greatest of " + x + " " + y + " " + z + ": " + greatest);
		System.out.println();
		
		return greatest;
			
	}
	
	static void check_bools() {
	// 3. Write a program declare two variables a & b and initialize them to true and false respectively. 
	//    Get the output of the following computations:
	//	  !a, a | b, (!a & b) | (a & !b)		
		
		// Declare bools
		boolean a = true;
		boolean b = false;
		
		System.out.println("Question 3: ");
		System.out.println("-----");
		
		// Compute and print
		System.out.println("!a: " + !a);
		System.out.println("(a | b): " + (a | b));
		System.out.println("(!a & b) | (a & !b): " + ((!a & b) | (a & !b)));
		System.out.println();
		
		return;		
			
	}
	
}
