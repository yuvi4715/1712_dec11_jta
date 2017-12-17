package com.revature.advancedConcepts;

/*
 * Nathan Poole
 * Question Twenty
 * Create a Runtime object and note at lease three methods. Imagine how you would
 * 		use them.
 */

public class QuestionTwenty {

	public static void main(String[] args) {
		Runtime rtt = Runtime.getRuntime();
		
		System.out.println(rtt.freeMemory());
		//rtt.freeMemory() 
		/*
		 * useful for allocating something of a size 
		 * relative to what is available or avoiding 
		 * using more memory than a machine has
		 */
		//rtt.exec(String command)
		/* 
		 * useful if you want to use java to automate
		 * tasks using java or you want java to launch
		 * non-java applications. 
		 */
		//rtt.load(String filename)
		/*
		 * useful for accessing java code that in
		 * specific but hard to reach places
		 */
		
	}
}
