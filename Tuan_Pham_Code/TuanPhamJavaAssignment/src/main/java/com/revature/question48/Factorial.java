package com.revature.question48;

import java.util.Scanner;

//Write a Java application that computes the factorial of a number.
public class Factorial {

	public static int computeFactorial(int n) {
		int factorial = 1;
		// Factorial of 0 and 1 both equal 1
		if (n == 0 || n == 1) {
			return 1;
		}
		else {
			// Increment the number up to the desired number and multiply each
			for (int i = 1; i <= n; i++) {
				factorial *=i;
			}
		}
		return factorial;
	}
	public static void main(String[] args) {
		System.out.println("Enter a number to compute the factorial");
		Scanner in = new Scanner(System.in);
		System.out.println("The factorial is " + computeFactorial(in.nextInt()));
		in.close();
	}

}
