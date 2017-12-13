package com.revature.week1_jason_shen;

import java.util.StringTokenizer;

public class AdvancedConcepts {
	
	// 16. Create a StringBuilder object. Use at least three methods to manipulate the String.
	static void stringBuilding() {
		StringBuilder my_string_builder = new StringBuilder();
		System.out.println("Starting new string: " + my_string_builder);
		
		// Using the StringBuilder append() method
		my_string_builder.append("hello");
		// New string should be hello now
		System.out.println("Appending... \nNew string: " + my_string_builder);
		
		// Using the StringBuilder reverse() method
		my_string_builder.reverse();
		// New string should now be "olleh"
		System.out.println("Reversing...\nNew string: " + my_string_builder);
		
		// Using the StringBuilder delete() method
		my_string_builder.delete(1, 3);
		// New string should now be "oeh"
		System.out.println("Deleting some chars...\nNew string: " + my_string_builder);
	}
	
	// 17. Create a new String with delimited tokens, such as “pickles:ketchup:mustard:onion” 
	//     and use StringTokenizer to parse out and print each token.
	static void tokens() {
		String s = "Revature-Yuvi-Jason";
		System.out.println("To be parsed: " + s);
		System.out.println("Parsed: ");
		StringTokenizer tokenizer = new StringTokenizer(s, "-");
		while (tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
		}
	}
	
	
	// 18. Create two String objects with number values (i.e. “20). Write a method that adds the two.
	
	static Integer addStrings(String s1, String s2) {
		Integer x = Integer.parseInt(s1);
		Integer y = Integer.parseInt(s2);
		System.out.println(s1 + " + " + y + " = " + (x+y));
		
		// 19. Request garbage collection in your method.
		System.gc();
		System.out.println("Garbage collection requested");
		return x + y;
	}
	
	
	// 20. Create a Runtime object and note at least three methods. Imagine how you would use them.

	static void myRuntime() {
		Runtime my_runtime_object = Runtime.getRuntime();
		
		System.out.println("Free memory: " + my_runtime_object.freeMemory());
		System.out.println("Max memory: " + my_runtime_object.maxMemory());
		System.out.println("Hash code: " + my_runtime_object.hashCode());
	}
}
