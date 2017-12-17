package com.revature.day1;

import java.util.Scanner;

public class KeyboardScanner {

	int someint;
	double somedouble;
	String somestring;
	
	{
		
	Scanner reader = new Scanner(System.in);
	System.out.println("please enter an integer");
	someint = reader.nextInt();
	
	//reader.close();
	
	System.out.println("Next, I would like you to enter another number; decimal");
	somedouble = reader.nextDouble();
	
	//reader.close();
	
	System.out.println("Finally, please enter a String");
	somestring = reader.next();
	
	reader.close();
	
	
	System.out.println(someint + " " + somedouble + " " + somestring);
	}
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
