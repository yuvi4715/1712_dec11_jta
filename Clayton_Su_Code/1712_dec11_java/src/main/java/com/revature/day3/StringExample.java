package com.revature.day3;

public class StringExample {

	public static void main(String[] args) {

	}
	
	void StringExample()
	{
		String s1 = "hello";
		String s2 = "hello";
		String s3 =  new String("hello");
		String s4 = new String("hello");
		
		System.out.println(s1.hashCode() + " : " + s1.toString());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		
		if (s1 == s2)
			System.out.println("s1==s2");
		else
			System.out.println("s1!=s2");
		
		if(s1.equals(s2) || s2.equals(s3))
		{
			if(s1.equals(s2))
			{
				System.out.println("s2 == s1");
			}
			else
			{
				System.out.println("s1 != s2");
			}
			if (s2.equals(s3))
			{
				System.out.println("s2 == s3");
			}
			else
			{
				System.out.println("s2 != s3");
			}
		}
	}
}
