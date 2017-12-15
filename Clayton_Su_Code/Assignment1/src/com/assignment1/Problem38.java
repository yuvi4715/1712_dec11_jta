package com.assignment1;

public class Problem38 {
	
	public static String replaceAChar(String s,char replacer ,int index)
	{
		StringBuilder temp = new StringBuilder(s);
		
		temp.setCharAt(index,replacer);
		//System.out.println(temp);
		
		return temp.toString();
	}
	
	public static void main(String[] args) {
		String sah = "Hello";
		String sah2 = "";
		int index = 0;
		char myChar = ' ';
		sah2 = replaceAChar(sah,myChar ,index);
		
		System.out.println(sah2);
	}

}
