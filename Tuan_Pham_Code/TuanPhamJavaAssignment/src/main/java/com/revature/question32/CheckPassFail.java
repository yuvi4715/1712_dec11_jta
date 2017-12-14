package com.revature.question32;

import java.util.Scanner;

//Write a program called CheckPassFail which prints "PASS" if the int variable "mark" is more than or equal to 50; or prints "FAIL" otherwise.
public class CheckPassFail {
	
	public void checkMark(int mark) {
		// Print PASS if greater than 50
		if (mark >= 50) {
			System.out.println("PASS");
		// Print FAIL if less than 50
		} else 
			System.out.println("FAIL");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter an integer");
		int n = in.nextInt();
		in.close();
		new CheckPassFail().checkMark(n);
	}

}
