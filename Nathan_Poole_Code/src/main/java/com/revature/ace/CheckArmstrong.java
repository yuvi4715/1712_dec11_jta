package com.revature.ace;

/*
 * Nathan Poole
 * Question Fourty-three
 * Write a Java program to check if a number is Armstrong or not
 */

public class CheckArmstrong {

	public static void main(String[] args) {
		
		checkArmstrong(1234);
		checkArmstrong(153);
	}

	private static void checkArmstrong(int i) {

		int total = 0, num = i, dig;
		while(num >0) {
			dig = num%10;
			num /= 10;
			total += Math.pow(dig, 3);
		}
		if( total == i) System.out.println(i + " is armstrong");
		else System.out.println(i+" is NOT armstrong");
	}
}
