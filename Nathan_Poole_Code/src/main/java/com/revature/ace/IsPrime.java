package com.revature.ace;

/*
 * Nathan Poole
 * Question Fourty-five
 * Write a method to determine if a number is prime
 * 
 */

public class IsPrime {

	public static void main(String[] args) {
		isPrime(7);
		isPrime(8);
		isPrime(9);
		isPrime(10);
		isPrime(11);
	}

	public static void isPrime(int i) {

		if((i%2)==0 || (i%3) == 0) System.out.println(i+" is not a prime number.");
		else System.out.println(i+" is a prime number");
	}
}
