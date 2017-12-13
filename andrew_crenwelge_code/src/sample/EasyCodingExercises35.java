package sample;

import java.util.Scanner;

public class EasyCodingExercises35 {

	public static void main(String[] args) {
		/*
		 * Write a program called KeyboardScanner to 
		 * prompt user for an int, a double, and a String. 
		 * Print the input onto the console.
		 */
		KeyboardScanner();
	}
	
	private static void KeyboardScanner() {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter an integer");
		int someint = sc.nextInt();
		System.out.println("enter a double");
		double somedouble = sc.nextDouble();
		System.out.println("enter a string");
		String somestr = sc.next();
		System.out.println(someint);
		System.out.println(somedouble);
		System.out.println(somestr);
		sc.close();
	}

}
