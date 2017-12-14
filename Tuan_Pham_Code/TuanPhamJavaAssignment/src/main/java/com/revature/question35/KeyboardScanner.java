package com.revature.question35;

import java.util.Scanner;

// Write a program called KeyboardScanner to prompt user for an int, a double, and a String. Print the input onto the console
public class KeyboardScanner {
	
	public void readKeyboard() {
		// Use Scanner class to get keyboard input
		Scanner in = new Scanner(System.in);
		
		// Get integer input and print
		System.out.println("Enter an int");
		int a = in.nextInt();
		
		// Get double input and print
		System.out.println("Enter a double");
		double b = in.nextDouble();
		
		// Get string input and print
		System.out.println("Enter a string");
		String c = in.next();
		
		System.out.println("You entered integer: " + a + ", double: " + b + " , and string: " + c);
		
		// Close Scanner
		in.close();
	}
 
	public static void main(String[] args) {
		new KeyboardScanner().readKeyboard();

	}

}
