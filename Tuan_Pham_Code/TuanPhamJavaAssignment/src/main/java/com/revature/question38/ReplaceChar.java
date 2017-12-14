package com.revature.question38;

import java.util.Scanner;

// Write a method to replace a given character in a String with another character.
public class ReplaceChar {

	public static String replace(String str, char charFind, char charReplace) {
		// Finds the specified character and replaces with new character
		return str.replace(charFind, charReplace);
	}
	public static void main(String[] args) {
		System.out.println("Enter a string");
		
		// Get string from user
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		
		// Get first character that is entered
		System.out.println("Enter a character to replace");
		char charFind = in.next().charAt(0);
		
		// Get character to replace with
		System.out.println("Enter a character to replace  " + charFind + " with");
		char charReplace = in.next().charAt(0);
		
		in.close();
		
		System.out.println(replace(str, charFind, charReplace));
		
	}

}
