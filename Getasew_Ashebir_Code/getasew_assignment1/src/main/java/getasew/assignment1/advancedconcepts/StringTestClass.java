package getasew.assignment1.advancedconcepts;

import java.util.StringTokenizer;

public class StringTestClass {
	public static void main(String[] args) {
		//Create a StringBuilder object. Use at least three methods 
		//to manipulate the String.
		
		StringBuffer st = new StringBuffer();
		st.append("string");
		System.out.println(st.toString());
		st.deleteCharAt(3);
		System.out.println(st.toString());
		st.setCharAt(3, 'r');
		System.out.println(st.toString());
		
		//17.Create a new String with delimited tokens, 
		//such as “pickles:ketchup:mustard:onion” and use StringTokenizer
		//to parse out and print each token.
		
		String st2 ="pickles:ketchup:mustard:onion";
		StringTokenizer tokens = new StringTokenizer(st2,":");
		//parsing and printing the string
		while(tokens.hasMoreTokens()) {
			System.out.println(tokens.nextToken());
		}
		//18.Create two String objects with number values (i.e. “20). 
		//Write a method that adds the two.
		String str1 = new String("40");
		String str2 = new String("50");
		System.out.println(addStrValues(str1,str2));
		//20.Create a Runtime object and note at least three methods.
		//Imagine how you would use them.

		Runtime rn = Runtime.getRuntime();
		System.out.println("free memory "+rn.freeMemory());
		//getting maximum memory
		System.out.println("maximum memory  "+rn.maxMemory());
		//calling garbage collector
		rn.gc();
		
	}
	public static int addStrValues(String s1,String s2) {
		System.gc(); //19.calling garbage collector.
	    return (Integer.parseInt(s1)+ Integer.parseInt(s2));
	   
	}
	

}