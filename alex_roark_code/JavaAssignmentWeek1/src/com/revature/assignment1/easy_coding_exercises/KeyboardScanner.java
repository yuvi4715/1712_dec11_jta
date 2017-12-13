package com.revature.assignment1.easy_coding_exercises;

import java.util.Scanner;

public class KeyboardScanner {

	public static void main(String[] args) {

		int userInt;
		double userDouble;
		String userString;
		
		Scanner keyboardScanner = new Scanner(System.in);
		
		System.out.println("Please enter an int:");
		userInt = keyboardScanner.nextInt();
		keyboardScanner.nextLine();
		
		System.out.println("Please enter a double:");
		userDouble = keyboardScanner.nextDouble();
		keyboardScanner.nextLine();
		
		System.out.println("Please enter a String:");
		userString = keyboardScanner.nextLine();
		
		keyboardScanner.close();
		
		System.out.println("You inputted:\n");
		System.out.println(userInt);
		System.out.println(userDouble);
		System.out.println(userString);
	}

}
