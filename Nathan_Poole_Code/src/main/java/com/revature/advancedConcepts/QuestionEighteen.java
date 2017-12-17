package com.revature.advancedConcepts;

/*
 * Nathan Poole
 * Question Eighteen
 * 18.	Create two String objects with number values (i.e. “20). 
 * 		Write a method that adds the two.
 */

public class QuestionEighteen {
	public static void main(String[] args) {
		System.out.println(addStrings("10", "20"));
	}
	
	public static int addStrings(String a, String b) {
		return Integer.parseInt(a)+Integer.parseInt(b);
	}
}
