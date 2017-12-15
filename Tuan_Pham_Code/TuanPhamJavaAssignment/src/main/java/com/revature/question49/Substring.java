package com.revature.question49;

import java.util.Scanner;

// Implement the substring method.
public class Substring {

	public static String substr(String str, int start, int end) {
		StringBuilder newStr = new StringBuilder();
		// If either the start or end is greater than the actual string, stop the program
		if (end > str.length() || start > str.length() || (start+end) > str.length()) {
			System.out.println("Substring out of bounds!");
			System.exit(0);
		} else {
			// Computer where to start the string and start at that index.
			// End is the length of the substring starting at start
			// Append and make a new string using StringBuilder
			for (int i = start; i < (start+end); i++) {
				newStr.append(str.charAt(i));
			}
		}
		
		return newStr.toString();
	}
	public static void main(String[] args) {
		System.out.println("Enter a string (white space counts as a character)");
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		System.out.println("Enter an integer where to start the index of the substring");
		int start = in.nextInt();
		System.out.println("Enter another integer for the length to the end the substring");
		int end = in.nextInt();
		System.out.println("The new substring is: " + substr(str,start, end));
		in.close();
	}

}
