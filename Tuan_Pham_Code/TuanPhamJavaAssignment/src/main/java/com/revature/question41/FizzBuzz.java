package com.revature.question41;

// Write a Java program that prints the numbers from 1 to 50. But for multiples of three print "Fizz" instead of the number and for 
// the multiples of five print "Buzz". For numbers which are multiples of both three and five print "FizzBuzz"
public class FizzBuzz {

	public static void fizzBuzz() {
		for (int i = 1; i <= 50; i++) {
			// If the number is a multiple of both 3 and 5 print FizzBuzz
			if ((i % 3 == 0) && (i % 5 == 0)) {
				System.out.print("FizzBuzz, ");
			}
			// For multiples of 3 print Fizz
			else if (i % 3 == 0) {
				System.out.print("Fizz, ");
			}
			// For multiples of 5 print Buzz
			else if (i % 5 == 0) {
				System.out.print("Buzz, ");
			}
			// If none are multiples of 3 or 5, print the number itself
			else 
				System.out.print(i + ", ");
		}
	}
	public static void main(String[] args) {
		fizzBuzz();
	}
}
