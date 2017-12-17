package com.revature.ace;

/*
 * Nathan Poole
 * Question Forty-four
 * Write a method to reverse a String without using API functions
 * 
 */

public class ReverseString {

	public static void main(String[] args) {
		System.out.println(reverseString("hello World"));
	}

	public static String reverseString(String string) {

		StringBuilder reverse = new StringBuilder();
		for(int i =string.length(); i>0; i--) {
			reverse.append(string.charAt(i-1));
		}
		return reverse.toString();
	}
}
