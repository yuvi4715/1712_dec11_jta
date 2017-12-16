package com.revature.week1.AdvancedCondingExercises;

public class ReverseString {

	public static void main(String[] args) {
		String str = "reverse";
		String r = "";
		int length = str.toCharArray().length;
		
		//Reversing an array
		for (int i = length - 1; i >= 0; i--) {
			r = r + str.charAt(i);
		}

		System.out.println(r);

	}

}
