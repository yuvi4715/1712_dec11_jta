package com.revature.day1;

import java.util.Scanner;

public class Number44 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String someString = "";
		int counter = 0;
		
		Scanner reader = new Scanner(System.in);
		System.out.println("Type something to see it reversed.");
		someString = reader.next();
		
		char[] array = someString.toCharArray();
		
		for (counter = array.length - 1; counter >= 0; counter--)
		{
			System.out.print(array[counter]);
		}

	}

}
