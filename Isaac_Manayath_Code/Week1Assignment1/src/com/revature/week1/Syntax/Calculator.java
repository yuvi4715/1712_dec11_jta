package com.revature.week1.Syntax;

public class Calculator {

	public static void main(String [] args) {
		
		CalculatorMethods tool = new CalculatorMethods();
	
		//Calling the Addition method
		int totalAdd = tool.add(4, 2);
		System.out.println("Added numbers between four and two " + totalAdd);
		
		//Calling the Subtract method
		int totalSubtract = tool.subtract(4, 2);
		System.out.println("Subtracts numbers between four and two " + totalSubtract);
		
		//Calling the Multiply method
		int totalMultiply = tool.multiply(4, 2);
		System.out.println("Multiply numbers between four and two " + totalMultiply);
		
		//Calling the Divide method
		int totalDivide = tool.divide(4, 2);
		System.out.println("Divide numbers between four and two " + totalDivide);

	}
	
}
