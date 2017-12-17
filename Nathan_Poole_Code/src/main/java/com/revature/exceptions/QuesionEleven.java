package com.revature.exceptions;

/*
 * Nathan Poole
 * Questions Eleven and Twelve and Fourteen
 * Create a class that manually throws an exception of your custom type
 * 
 * Use System.out.println( ) to note where you are in the control flow. 
 * 		Example: “Starting try block”, “Ending try block”, 
 * 				 “Starting catch block”, etc.
 * 
 * Implement a finally block that prints a graceful goodbye message
 */

public class QuesionEleven {
	
	public static void main(String[] args) {
		System.out.println("Starting Try block");
		try {
			System.out.println("Throwing QusetinTen exception");
			throw new QuestionTen();
		} 
		catch(QuestionTen e){
			System.out.println("QuestionTen Caught");
			System.out.println(e.getMessage());
			System.out.println("Done Catching");
		}
		finally {
			System.out.println("Have a nice day!");
		}
		
	}
}
