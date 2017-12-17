package com.revature.day1;

import java.util.StringTokenizer;

public class Number17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input = "apples:oranges:pears:bananas";
		String seperator = ":";
StringTokenizer theString = new StringTokenizer(input, seperator);

while (theString.hasMoreElements()) {
	System.out.println("the words are seperate: " + theString.nextElement());
}

		
	}

}
