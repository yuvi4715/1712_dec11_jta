package com.revature.ece;

/*
 * Nathan Poole
 * Question Thirty-two
 * Write a program called CheckPassFail which prints "PASS" if the int 
 * 		variable "mark" is more than or equal to 50; or prints "FAIL" otherwise.
 */

public class CheckPassFail {

	public static void main(String[] args) {
		checkPassFail(49);
		checkPassFail(50);
		checkPassFail(51);
	}

	private static void checkPassFail(int mark) {
		if(mark>=50) System.out.println("PASS");
		else System.out.println("FAIL");
	}
}
