package com.revature.week1.Syntax;

public class CalculatorOneClass {

	//Add method
	public static int add(int one, int two) {
		
		int total = 0;
		total = one + two;
		return total;
	}
	
	//Subtract method
	public static int subtract(int one, int two) {
		
		int total = 0;
		total = one - two;
		return total;
	}

	//Multiply method
	public static int multiply(int one, int two) {
	
		int total = 0;
		total = one * two;
		return total;
	}
	
	//Divide Method
	public static int divide(int one, int two) {
	
		int total = 0;
		total = one / two;
		return total;
	}

	//Calling all these methods to do computations
	public static void main(String [] args) {
		int totalAdd = add(4, 2);
		System.out.println("Added numbers between four and two " + totalAdd);
		int totalSubtract = subtract(4, 2);
		System.out.println("Subtracts numbers between four and two " + totalSubtract);
		int totalMultiply = multiply(4, 2);
		System.out.println("Multiply numbers between four and two " + totalMultiply);
		int totalDivide = divide(4, 2);
		System.out.println("Divide numbers between four and two " + totalDivide);
	}
}
