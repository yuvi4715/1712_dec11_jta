package com.revature.question45;

import java.util.Scanner;

// Write a method to determine if a number is prime. 
public class Prime {

	public static void checkPrime(int n) {
		// Assumes 1 is not a prime number
		if (n == 1) {
			System.out.println("1 is not a prime number");
			System.exit(0);
		}
		// Loop through all numbers up to n and divide by each. If n is divisible by any number other than itself, it is not prime
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				System.out.println(n + " is not a prime number");
				System.exit(0);
			}
		}
		System.out.println(n + " is a prime number");

	}
	public static void main(String[] args) {
		System.out.println("Enter a number to check if it is a prime number");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		checkPrime(n);
		in.close();

	}

}
