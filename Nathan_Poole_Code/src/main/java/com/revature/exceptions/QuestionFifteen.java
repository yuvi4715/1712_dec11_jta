package com.revature.exceptions;

/*
 * Nathan Poole
 * Question Fifteen
 * Use the System.exit(0) command in the try block and rerun the 
 * 		application. Note the console output to see if the finally 
 * 		block executes(spoilers: it dosen't).
 */

public class QuestionFifteen {
	
	public static void main(String[] args) {
		sysExit();
	}
	
	public static void sysExit() {
		System.out.println("Starting Try block");
		try {
			System.out.println("Caution: System.out()");
			System.exit(0);
		} finally {
			System.out.println("This message will never print.");
		}
	}
}
