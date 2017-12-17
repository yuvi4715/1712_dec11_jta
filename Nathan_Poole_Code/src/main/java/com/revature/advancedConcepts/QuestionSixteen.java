package com.revature.advancedConcepts;

/*
 * Nathan Poole
 * Question Sixteen
 * Create a StringBuilder object. Use at least three methods to manipulate 
 * 		the String.
 */

public class QuestionSixteen {

	public static void main(String[] args) {
		buildYourString();
	}

	private static void buildYourString() {
		StringBuilder MyString = new StringBuilder("Hello");
//.toString converts the contents to a string		
		System.out.println(MyString.toString());
//.append("text") adds 'text' to the end of MyString		
		MyString.append(" World");
		System.out.println(MyString.toString());
//.indexOf gives the index of the first occurrence of the substring passed to it
//.substring returns a substring staring at the index given		
		System.out.println(MyString.substring(MyString.indexOf("World")));  
		
	}
}
