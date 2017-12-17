package com.revature.ece;

/*
 * Nathan Poole
 * Question Thirty-six
 * Write a program called Arithmetic that takes three command-line arguments: 
 * 		two integers followed by an arithmetic operator (+, -, * or /). The 
 * 		program shall perform the corresponding operation on the two integers 
 * 		and print the result.
 */

public class Arithmetic {

	public static void main(String[] args) {
		if (args.length == 3) {
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			String op = args[2];
			arithmetic(a, b, op);
		} else {
			System.out.println("Incorect Arguments: Int Int Operator");
		}
	}

	private static void arithmetic(int a, int b, String op) {

		switch (op) {
		case "+":
			System.out.println(a + b);
			break;
		case "-":
			System.out.println(a - b);
			break;
		case "*":  //Note: you can't actually submits "*" as a command line argument because it is a regular expression. 
			System.out.println(a * b);
			break;
		case "/":
			System.out.println((double)a / b);
			break;
		default:
			System.out.println("Invalid operator");
		}

	}
}
