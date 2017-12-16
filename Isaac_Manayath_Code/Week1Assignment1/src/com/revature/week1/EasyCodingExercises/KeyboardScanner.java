package com.revature.week1.EasyCodingExercises;

import java.util.Scanner;

public class KeyboardScanner {

	public static void main(String[] args) {
		System.out.println("Expect an int result");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		System.out.println("The integer input is " + i);

		System.out.println("Expect a double result");
		double d = sc.nextDouble();
		System.out.println("The double input is " + d);

		System.out.println("Expect a String result");
		String s = sc.next();
		System.out.println("The string input is " + s);

	}

}
