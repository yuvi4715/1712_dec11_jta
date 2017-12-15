package com.assignment1;

import java.util.StringTokenizer;

public class Problem16thru19 {

	public static void main(String[] args) {
		stringEx();
		tokenEx();
		addStringNums();
		
		
		
	}
	
	public static void stringEx()
	{
		StringBuilder s = new StringBuilder("Hello");
		System.out.println(s);
		
		s.append(" man");
		System.out.println(s);
		
		s.delete(0, 4);
		System.out.println(s); //hello -> o
		
		s.deleteCharAt(0);
		System.out.println(s);
	}
	
	public static void tokenEx()
	{
		StringTokenizer s = new StringTokenizer("pickles:ketchup:mustard:onion",":",false);
		while(s.hasMoreElements())
			System.out.println(s.nextToken());	
	}
	
	public static void addStringNums()
	{
		String x = "20";
		String y = "30";
		
		int a = Integer.parseInt(x);
		int b = Integer.parseInt(y);
		
		System.out.println((a+b));
		
		System.gc();
	}

}
