package com.revature.assignment1.advanced_concepts;

import java.util.StringTokenizer;

public class Q17 {

	public static void main(String[] args) {

		String condiments = "pickle:ketchup:mustard:onion";
		
		StringTokenizer stringTokenizer = new StringTokenizer(condiments, ":");
		
		while (stringTokenizer.hasMoreTokens()) {
			System.out.println(stringTokenizer.nextToken());
		}
	}

}
