package com.revature.as1;

import java.util.Arrays;
import java.util.Scanner;

public class KeyboardInputScanner {

	Scanner in;

	public KeyboardInputScanner() {
		in = new Scanner(System.in);
	}

	public int[] setIntArgs(int numArgs) {
		//Sets basic int arguments
		int[] vals = new int[numArgs];
		for (int i = 0; i < numArgs; i++) {
			System.out.print("Please set variable " + (i + 1) + ": ");
			try {
				vals[i] = Integer.parseInt(in.nextLine());
			} catch (Exception e) {
				System.out.println("What you just did? It was wrong. Try again.");
				i--;
			}
		}

		return vals;
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
	
	public String[] setStringArgs(int numArgs) {
		//Sets basic string arguments
		String[] vals = new String[numArgs];
		for (int i = 0; i < numArgs; i++) {
			System.out.print("Please set variable " + (i + 1) + ": ");
			try {
				vals[i] = in.nextLine();
			} catch (Exception e) {
				System.out.println("What you just did? It was wrong. Try again.");
				i--;
			}
		}

		return vals;
		
	}
	
	public String[] setStringArgs(int numArgs, String[] DisplayText) {
		//For when you want to pass a set of prompts 

		String[] vals = new String[numArgs];
		for (int i = 0; i < numArgs; i++) {
			System.out.print((i + 1) + " " + DisplayText[i]);
			try {
				vals[i] = in.nextLine();
			} catch (Exception e) {
				System.out.println("What you just did? It was wrong. Try again.");
				i--;
			}
		}

		return vals;
		
	}
	
	public String[] setStringArgs(int numArgs, String DisplayText) {
		//For when you want to pass a single nonstandard prompt 

		String[] vals = new String[numArgs];
		for (int i = 0; i < numArgs; i++) {
			System.out.print((i + 1) + " " + DisplayText);
			try {
				vals[i] = in.nextLine();
			} catch (Exception e) {
				System.out.println("What you just did? It was wrong. Try again.");
				i--;
			}
		}

		return vals;
		
	}

	public int setMode(String options) { // modes should be passed comma separated, whitespace is trimmed
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
