package com.revature.advancedConcepts;

/*
 * Nathan Poole
 * Question Nineteen
 * Request Garbage Collection in your method
 */

public class QuestionNineteen {
	
	public static void main(String[] args) {
		myMethod();
	}

	private static void myMethod() {
		System.out.println("Submiting request for garbage collection");
		System.gc();
		System.out.println("Request recieved. Maybe processed?");
	}
}
