package com.revature;

public class BooleanOutput {
	private static Boolean a = true;
	private static Boolean b = false;

	//here we are displaying the boolean values that i set
	void displayBooleanValues() {
		
		System.out.println(!a);
		System.out.printf("%1b | %2b",a,!b);
		System.out.println("");
		System.out.printf("(%1b & %2b) | (%3b & %5b)", !a, !b, a,b);
	}
}
