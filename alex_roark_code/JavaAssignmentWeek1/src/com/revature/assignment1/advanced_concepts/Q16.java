package com.revature.assignment1.advanced_concepts;

public class Q16 {

	public static void main(String[] args) {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Hello, World!");
		stringBuilder.replace(7, 12, "Yuvi");
		stringBuilder.reverse();
		
		System.out.println(stringBuilder);
	}

}
