package com.revature.question44;

import java.util.Scanner;

// Write a method to reverse a String without using API functions.
public class reverseString {

	public static void reverse(String str) {
		String newString = "";
		// Use a loop that traverses the string backwards
		for (int i = str.length()-1; i >= 0; i--) {
			// Append the chars in reverse order to string
			newString = newString + str.charAt(i);		
		}
		System.out.println(newString);
	}
	public static void main(String[] args) {
		System.out.println("Enter a string to reverse");
		Scanner in = new Scanner(System.in);
		reverse(in.nextLine());
		in.close();
	}

}
