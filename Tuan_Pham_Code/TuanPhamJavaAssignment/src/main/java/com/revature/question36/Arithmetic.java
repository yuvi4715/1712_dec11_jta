package com.revature.question36;

// Write a program called Arithmetic that takes three command-line arguments: two integers followed by an arithmetic operator (+, -, * or /). 
// The program shall perform the corresponding operation on the two integers and print the result.
public class Arithmetic {

	public int compute(int a, int b, String c) {
		
		// If operator is + add the two numbers
		if (c.equals("+")) {
			return a + b;
		// If operator is - subtract the two numbers
		} else if (c.equals("-")) {
			return a - b;
		// If operator is * multiply the two numbers
		} else if (c.equals("*")) {
			return a * b;
		// If operator is / divide the two numbers
		} else if (c.equals("/")) {
			return a / b;
		}
		else 
			System.out.println("Incorrect arithmetic operator");
			return 0;
	
	}
	public static void main(String[] args) {
		
		// Convert the first two arguments from String to integer
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		String c = args[2];
		System.out.println(a + " " + c + " " + b + " = " + new Arithmetic().compute(a, b, c));
		

	}

}