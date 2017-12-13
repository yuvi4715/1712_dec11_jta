package com.revature.question1620;

import java.util.StringTokenizer;

/*
16.	Create a StringBuilder object. Use at least three methods to manipulate the String.
17.	Create a new String with delimited tokens, such as “pickles:ketchup:mustard:onion” and use StringTokenizer to parse out and print each token.
18.	Create two String objects with number values (i.e. “20). Write a method that adds the two.
19.	Request garbage collection in your method.
20.	Create a Runtime object and note at least three methods. Imagine how you would use them.
 */
public class AdvancedConcepts {
	
	public void stringBuilderEx() {
		// StringBuilder object that modifies string
		StringBuilder sb = new StringBuilder("this is my string");
		System.out.println(sb);
		sb.insert(0, "Hello, ");
		System.out.println(sb);
		sb.append(" example");
		System.out.println(sb);
		sb.deleteCharAt(5);
		System.out.println(sb);
	}
	
	public void stringTokenizerEx() {
		String str = "apples:oranges:pear:cherries";
		
		//Using StringTokenizer to split up the string with delimiter ":"
		StringTokenizer token = new StringTokenizer(str,":");
		while(token.hasMoreTokens()) {
			System.out.print(token.nextToken() + " ");
		}
		System.out.println("");
	}
	
	public void sumString(String str1, String str2) {
		int a, b, sum; 
		
		// Parse the strings into integer values to sum up
		a = Integer.parseInt(str1);
		b = Integer.parseInt(str2);
		sum = a + b;
		System.out.println(str1 + " + " + str2 + " = " + sum);	
		
		// Requesting garbage collection
		System.gc();
	}
	
	public void createRuntimeObject() {
		// Run a loop that creates objects during runtime
		for (int i = 0; i < 2; i++) {
			AdvancedConcepts acr = new AdvancedConcepts();
			
			// Call sumString method that has the garbage collection request to delete unreferenced Objects
			acr.sumString("5", "100");
			// Other uses of a runtime Object would be to dynamically allocate certain things you want 
			// or to calculate unknown values that may be constantly changing.
		}
	}
	public static void main(String[] args) {
		
		AdvancedConcepts ac = new AdvancedConcepts();
		ac.stringBuilderEx();
		ac.stringTokenizerEx();
		
		String a = "10";
		String b = "15";
		
		ac.sumString(a, b);
		
		
	}
}
