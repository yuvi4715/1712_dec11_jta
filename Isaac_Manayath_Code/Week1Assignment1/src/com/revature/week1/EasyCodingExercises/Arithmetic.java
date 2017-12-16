package com.revature.week1.EasyCodingExercises;

public class Arithmetic {

	public static void main(String[] args) {

		// The code works when you run a command line for this kind of program
		int total = 0;

		if (args[2].equalsIgnoreCase("+")) {
			total = Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
		} else if (args[2].equalsIgnoreCase("-")) {
			total = Integer.parseInt(args[0]) - Integer.parseInt(args[1]);
		} else if (args[2].equalsIgnoreCase("*")) {
			total = Integer.parseInt(args[0]) * Integer.parseInt(args[1]);
		} else if (args[2].equalsIgnoreCase("*/")) {
			total = Integer.parseInt(args[0]) / Integer.parseInt(args[1]);
		}

		System.out.println("The total of the two arguments" + total);
	}

}
