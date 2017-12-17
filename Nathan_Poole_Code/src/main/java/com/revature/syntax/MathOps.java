package com.revature.syntax;

/*
 * Nathan Poole
 * Question Five
 * In one project, create two classes. One class should contain 
 * 		only methods (add, subtract, multiply and divide). The other 
 * 		class should contain only the main() method which calls each 
 * 		of the methods from the previous class.
 * 
 * This is the math operations class.
 * the main method class is RunMath
 */

public class MathOps {
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
}
