package com.revature.question43;

import java.util.Scanner;

// Write a Java program to check if a number is Armstrong or not.
public class Armstrong {
	/* An Armstrong number is a number such that the sum
	of its digits raised to the third power is equal to the number
	itself.  For example, 371 is an Armstrong number, since
	3**3 + 7**3 + 1**3 = 371
	*/
	
	public static void checkArmstrong(int n) {
		int sum = 0;
		int rightMostDigit;
		int originalNumber;
		
		originalNumber = n;

		while (n > 0) {
			// Mod n by 10 to get the right most digit in the tenths place
			rightMostDigit = n % 10;
			
			// let n be the other numbers from the hundredths place on  to be tested later in the loop
			n /= 10;
			
			// Cube the right most digit and store it to be summed
			sum = (int) (sum + Math.pow(rightMostDigit, 3));
		}
		
		// If the sum of all the cubed digits equals the original number n, it is an Armstrong number
		if (originalNumber == sum) {
			System.out.println(originalNumber + " is an Armstrong number");
		} else {
			System.out.println(originalNumber + " is not an Armstrong number");
		}
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a number to check if it is an Armstrong number");
		int n = in.nextInt();
		in.close();
		checkArmstrong(n);
	}
}
