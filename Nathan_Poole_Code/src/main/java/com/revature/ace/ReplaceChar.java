package com.revature.ace;

/*
 * Nathan Poole
 * Question Thirty-eight
 * Write a method to replace given character in a String with another character
 * 
 */

public class ReplaceChar {

	public static void main(String[] args) {
		System.out.println(replaceChar("Hello World", "j", "l"));
	}
	
	public static String replaceChar(String og, String newChar, String oldChar) {
		
		int i;
		StringBuilder newString = new StringBuilder(og); 
		while ((i = newString.indexOf(oldChar)) != -1) {
			newString.setCharAt(i, newChar.charAt(0));
		}
		return newString.toString();
	}
}
