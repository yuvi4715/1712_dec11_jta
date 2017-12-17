package com.revature.ace;

/*
 * Nathan Poole
 * Question Fourty-one
 * Write a Java program that prints the numbers from 1 to 50. But for multiples of 
 * 		three print "Fizz" instead of the number and for the multiples of five 
 * 		print "Buzz". For numbers which are multiples of both three and five print 
 * 		"FizzBuzz"
 * 
 */

public class NumbersAreFun {

	public static void main(String[] args) {
		
		for(int i=1;i<=50;i++) fizzBuzz(i);
	}

	private static void fizzBuzz(int i) {

		if((i%3)==0 || (i%5)==0) {
			if((i%3)==0) System.out.print("Fizz");
			if ((i%5)==0) System.out.print("Buzz");
			System.out.println();
		} else System.out.println(i);
	}
}
