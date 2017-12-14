package com.revature.week1_jason_shen;

public class Syntax {
	
	
	// 4. Write a program to add, subtract, multiply and divide two numbers using methods with 
	//	  parameters using only one class.
	
	// 5. In one project, create two classes. One class should contain only methods (add, subtract, multiply and divide). 
	//    The other class should contain only the main() method which calls each of the methods from the previous class.
	
	// I think my implementation as well as how I'm organizing my files is sufficient for the purposes of questions 4 as well as 5.
	// Question 5 is essentially an extension of question 4 that is conveying the idea of invoking the methods of one class, call it class A,
	// from within the main method of a different class, call that class B. For the sake of keeping all 45 questions organized, I am
	// putting basicOps_2 (class A) under syntax.java and invoking the method from the main() of solution.java (class B) 

	public static class basicOps_2 {
	
		// I chose to use void functions here since I'm not really using these for any purpose other than
		// printing out the result. In some other scenario I might want the method to return the result.
		
		public static int add(int x, int y) {
			int sum = x + y;
			System.out.println("Sum of " + x + " and " + y + ": " + sum);
			return sum;
		}
		
		public static int subtract(int x, int y) {
			int diff = x - y;
			System.out.println("Difference of " + x + " and " + y + ": " + diff);
			return diff;
		}
		
		public static int multiply(int x, int y) {
			int prod = x * y;
			System.out.println("Product of " + x + " and " + y + ": " + prod);
			return prod;
		}
		
		public static int divide(int x, int y) {
			int quot = x / y;
			System.out.println("Quotient of " + x + " and " + y + ": " + quot);			
			return quot; 
		}
	}
	
	
	// 6. Create an example for each control statement.
	static void controls(int x, int y) {
		
		// Conditions or mutually exclusive events - If...else...else if..."
		System.out.println("Testing if statements...");
		if (x < 30) {
			System.out.println("X is less than 30");
		}
		else if (x < 50) {
			System.out.println("X is between 30 and 50");
		}
		else {
			System.out.println("X is greater than 50");
		}
		
		// Switch cases
		System.out.println("Testing switches");
		switch(y) {
		case 0:
			System.out.println("Y is 0");
			break;
		case 1:
			System.out.println("Y is 1");
			break;
		default:
			System.out.println("Y is greater than 1");
		}
		
		// For loop
		System.out.println("Testing for loop...");
		for (int i = 0; i < 5; i++) {
			System.out.println("This is was printed " + i +  " times using a for loop");
		}
		
		// While loop - Performs actions if condition is met
		System.out.println("Testing while loop...");
		int while_var = 0;
		
		while (while_var < 5 ) {
			while_var++;
			System.out.println(while_var);
		}
		
		// Do while loop - Performs actions once, regardless if condition is met, then loops based on if condition is met
		System.out.println("Testing do while loop, should print 6...");
		do {
			while_var++;
			System.out.println(while_var);
		} while(while_var < 5);
		
		// Break and Continue
		System.out.println("Testing breaks and continues - Continues at 2 or if X == 2, breaks at X != 2 or 5");
		int temp = 0;
		while (true) {
			temp++;
			// if even, continue
			if (temp == 2) {
				System.out.println("Found 2, continuing...");
				continue;
			}
			else if (temp == x){
				System.out.println("Found X, breaking...");
				break;
			}
			else if (temp == 5) {
				System.out.println("Found 5, breaking...");
				break;
			}
		}
		
	}
	
}
