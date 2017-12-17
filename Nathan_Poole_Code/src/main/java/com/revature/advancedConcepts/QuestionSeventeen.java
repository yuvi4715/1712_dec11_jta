package com.revature.advancedConcepts;

/*
 * Nathan Poole
 * Question Seventeen
 * Create a new String with delimited tokens, such as 
 * 		“pickles:ketchup:mustard:onion” and use StringTokenizer 
 * 		to parse out and print each token.
 */

import java.util.StringTokenizer;

public class QuestionSeventeen {
	
	public static void main(String[] args) {
		parseTheString();
	}

	private static void parseTheString() {
		String myString = new String("pickles:ketchup:mustard:onion");
		
		StringTokenizer spliter = new StringTokenizer(myString.toString(),":");
		
	     while (spliter.hasMoreTokens()) {
	         System.out.println(spliter.nextToken());
	     }
	}
}
