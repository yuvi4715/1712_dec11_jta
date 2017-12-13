package com.revature.strings;

import java.util.StringTokenizer;
import org.apache.log4j.Logger;

public class StringExample {

	final static Logger logger = Logger.getLogger(Logger.class);
	public static void main(String[] args) {
		//stringExample();
		//performanceCheck();
		//moreFunWithStrings();
		tokenExample();
	}

	/*
	 * String is a java object, also described as an array of characters.
	 * String is an IMMUTABLE object.
	 * -What is immutable?
	 * -Cannot be changed.
	 */
	
	static void stringExample() {
		
		new StringExample().hashCode();
		
		String s1 = "hello";
		String s2 = "hello";
		System.out.println(s2.hashCode());
		String s3 = new String("hello");
		String s4 = new String("hello");
		s2 = "hello world";
		System.out.println(s2.hashCode());

		System.out.println("value of s2 " + s2);
		System.out.println(s1.hashCode() + " : " + s1.toString());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		
		if (s1 == s2) {
			System.out.println("s1=s2");
		} else {
			System.out.println("s1!=s2");
		}
		if (s2 == s3) {
			System.out.println("s2=s3");
		} else {
			System.out.println("s2!=s3");
		}
		
		if (s1.equals(s2) || s2.equals(s3)) {
			if (s1.equals(s2)) {
				System.out.println("s1 equals s2");
			}
			else {
				System.out.println("s1 is not equal to s2");
			}
			if (s2.equals(s3)) {
				System.out.println("s2 equals s3");
			}
			else {
				System.out.println("s2 is not equal to s3");
			}
		}
	}
	
	public static void performanceCheck() {
		long starttime1 = System.nanoTime();
		for (int i=0; i<10000; i++) {
			String s5 = new String("my daughter would not teach me guitar unless I gave her some screen time in her tablet");
		}
		
		long endtime1 = System.nanoTime();
		System.out.println(endtime1 - starttime1);
		
		long starttime2 = System.nanoTime();
		for (int i=0; i<10000; i++) {
			StringBuffer s6 = new StringBuffer("my daughter would not teach me guitar unless I gave her some screen time in her tablet");
		}
		
		long endtime2 = System.nanoTime();
		System.out.println(endtime2 - starttime2);
		
		long starttime3 = System.nanoTime();
		for (int i=0; i<10000; i++) {
			StringBuilder s7 = new StringBuilder("my daughter would not teach me guitar unless I gave her some screen time in her tablet");
		}
		
		long endtime3 = System.nanoTime();
		System.out.println(endtime3 - starttime3);
	}
	
	public static void moreFunWithStrings() {
		String s8 = " Are we done yet? No this is gonna take for next 10 weeks ";
		System.out.println(s8.length());
		System.out.println(s8.charAt(10));
		System.out.println(s8.substring(10, 20));
		System.out.println(s8.trim());
		System.out.println(s8.concat(" I just got added to the original string"));
		System.out.println(s8.toUpperCase());
		System.out.println(s8.toLowerCase());
		String[] s9 = s8.split(" ");
		for (String elements: s9) {
			System.out.println(elements);
		}
	}
	
	public static void tokenExample() {
		String s10 = "we learnt the differences between final, finally and finalize. "
				+ "Also we learnt the differences between string, sting buffer and string builder";
		StringTokenizer tokens = new StringTokenizer(s10, " ");
		while(tokens.hasMoreElements()) {
			Object s11 = tokens.nextElement();
			System.out.println(s11);
			logger.info("messing with string tokenizer " + s11);
		}
	}
}
