package com.revature.syntax;

/*
 * Nathan Poole
 * Question Five
 * In one project, create two classes. One class should contain 
 * 		only methods (add, subtract, multiply and divide). The other 
 * 		class should contain only the main() method which calls each 
 * 		of the methods from the previous class.
 * 
 * This is the main method class.
 * Math operations class is MathOps
 */

public class RunMath {
	public static void main(String[] args) {
		int num1 = 3, num2 = 7;
		System.out.println(MathOps.addition(num1, num2));
		System.out.println(MathOps.subtraction(num1, num2));
		System.out.println(MathOps.multiplication(num1, num2));
		System.out.println(MathOps.division(num1, num2));
	}
}
