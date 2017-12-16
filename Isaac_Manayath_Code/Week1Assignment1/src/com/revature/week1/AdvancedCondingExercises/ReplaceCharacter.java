package com.revature.week1.AdvancedCondingExercises;

public class ReplaceCharacter {

	public static void main(String[] args) {
		String s = "hello";
		char c = 'e';
		char d = 'z';
		String replaced = Replace(s, c, d);

		System.out.println(replaced);
	}

	// Replaced a character with another character
	public static String Replace(String a, char c, char d) {
		char[] chars = a.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (c == chars[i]) {
				chars[i] = d;
			}
		}
		String b = new String(chars);
		return b;
	}

}
