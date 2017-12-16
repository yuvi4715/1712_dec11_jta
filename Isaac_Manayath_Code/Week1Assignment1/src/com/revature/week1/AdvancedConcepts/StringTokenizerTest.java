package com.revature.week1.AdvancedConcepts;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	
	public static void main(String[] args) {
	
		String str = "pickles:ketchup:mustard:onion";
		StringTokenizer tokenizer = new StringTokenizer(str, ":");
		//Printing out tokens
		while(tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}
	}
}
