package com.revature;

import java.util.StringTokenizer;

public class ManipulateStrings {
	
	void letterCount(String input) {
		char[] inputChar = input.toCharArray();
		int counter = 0;
		for(char i : inputChar) {
			if(i == 'a') {
				counter++;
			}
		}
		
		System.out.printf("\nFound %d a's in that string!", counter);
	}
	
	void reverseString(String input) {
		StringBuffer sb = new StringBuffer(input);
		
		sb.reverse();
		System.out.printf("\n%s",sb);
	}
	
	void charToString(char[] input) {
		String newString = new String(input);
		System.out.printf("\nNew String: %s",newString);
	}
	
	void stringLenght(String input) {
		System.out.printf("The lenght of this string is %d", input.length());
		
	}

	void parser(String input, String delimiter) {

		StringTokenizer stringToken = new StringTokenizer(input, delimiter);
		
		while(stringToken.hasMoreElements()) {
			System.out.println(stringToken.nextElement());
		}
	}
	
	void addStrings(String one, String two) {
		try {
			System.out.println(Integer.parseInt(one) + Integer.parseInt(two));
		}
		catch(Exception e){System.out.println("You did not enter a valid number");}
		
		System.gc();
	}
	
	
	
	
	
	
	
	
}
