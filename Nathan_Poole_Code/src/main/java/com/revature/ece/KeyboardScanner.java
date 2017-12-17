package com.revature.ece;

/*
 * Nathan Poole
 * Question Thirty-five
 * Write a program called KeyboardScanner to prompt user for an int, 
 * 		a double, and a String. Print the input onto the console.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardScanner {

	public static void main(String[] args) {
		keyboardScanner();
	}

	private static void keyboardScanner() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputI;
		double inputDB;
		String inputS;

		try {
			System.out.print("Enter an Interger value: ");
			inputI = Integer.parseInt(br.readLine());
			System.out.print("Enter a Double value: ");
			inputDB = Double.parseDouble(br.readLine());
			System.out.print("Enter a String: ");
			inputS = br.readLine();
			System.out.println(inputI);
			System.out.println(inputDB);
			System.out.println(inputS);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
}
