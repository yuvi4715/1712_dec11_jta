package com.revature.as1.easy;

import java.util.Arrays;
import java.util.Scanner;

public class ProjectKeyboardInputScanner {
	
	
	
	public static void main(String[] args) {
		ProjectKeyboardInputScanner sc = new ProjectKeyboardInputScanner();
		
		int intArg = sc.setIntArgs();
		double dArg = sc.setDoubleArgs();
		String sArg = sc.setStringArgs();
		
		System.out.println("You entered: " + intArg + " " + dArg + " " + sArg );
		
		
	}

	Scanner in;

	public ProjectKeyboardInputScanner() {
		in = new Scanner(System.in);
	}
	
	public int setIntArgs() {
		//Sets basic int arguments
		int out = 0;
		boolean setting = true;
		while(setting) {
			System.out.print("Please set an int variable: ");
			try {
				out = Integer.parseInt(in.nextLine());
				setting = false;
			} catch (Exception e) {
				System.out.println("What you just did? It was wrong. Try again.");
			}
		}

		return out;
	}
	
	public double setDoubleArgs() {
		//Sets basic int arguments
		double vals = 0.0;
		boolean setting = true;
		while(setting) {
			System.out.print("Please set a double variable: ");
			try {
				vals = Double.parseDouble(in.nextLine());
				setting = false;
			} catch (Exception e) {
				System.out.println("What you just did? It was wrong. Try again.");
			}
		}

		return vals;
	}
	
	public String setStringArgs() {
		//Sets basic string arguments
		String val = "";
		boolean setting = true;
		while(setting) {
			System.out.print("Please set a string variable: ");
			try {
				val = in.nextLine();
				setting = false;
			} catch (Exception e) {
				System.out.println("What you just did? It was wrong. Try again.");
			}
		}

		return val;
		
	}
	

	public int setMode(String options) { 
		// modes should be passed comma separated, whitespace is trimmed
		String[] modes = options.split(",");
		String input;
		Arrays.stream(modes).map(String::trim).toArray(unused -> modes);

		int index = -1;

		while (true) {
			System.out.print("Please select a mode for the project. Options are " + options + ": ");
			try {
				input = in.nextLine();
				index = Arrays.asList(modes).indexOf(input);
				if (index != -1) {
					break;
				} else {
					System.out.println("Invalid mode selected. Please try again.");
				}
			} catch (Exception e) {
				System.out.println("What you just did? It was wrong. Try again.");
			}

		}

		return index;
	}

	public void close() {
		in.close();
	}
}
