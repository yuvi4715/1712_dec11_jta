package com.revature.ace;

/*
 * Nathan Poole
 * Question Forty
 * Write a Java program to print the first 100 Fibonacci numbers using 
 * 		iteration. Rewrite using recursion.
 */

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
	
	static int max = 0;
	
	public static void main(String[] args) {
		
		fibItorator();
		fibStart();
	}

	private static void fibStart() {

		System.out.println("0.0 1");
		System.out.println("1.0 2");
		fibRecursive(0, 1);
	}

	private static void fibRecursive(double a, double b) {

		double c = a+b;
		if(max<98) {
			max++;
			System.out.println(c+ " " + (max+2));
			fibRecursive(b, c);
		}
	}

	private static void fibItorator() {
		
		List<Double> fib = new ArrayList<>();
		fib.add(0.0);
		fib.add(1.0);
		for(int i = 2; i<=99; i++) {
			fib.add(fib.get(i-1)+fib.get(i-2));
		}
		
		for(Double i: fib) {
			System.out.println(i);
		}
		
	}
	
	
}
