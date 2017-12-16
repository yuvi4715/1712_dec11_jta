package com.revature.week1.AdvancedConcepts;

public class StringBuilderTest {
	
	public static void main(String[] args) {
		StringBuffer str1 = new StringBuffer("String1");
		System.out.println(str1);
		//appending on the stringbuffer
		str1.append(" and String2");
		System.out.println(str1);
		//Reversing the stringbuffer
		str1.reverse();
		System.out.println(str1);
		//Total capacity of the stirngbuffer
		System.out.println(str1.capacity());
	}

}
