package com.revature.day1;

import java.util.Scanner;

public class Arithmetic {
	
	int int1;
	int int2;
	String operator;
	String realOperator;
	double result;
	
	{
		
	Scanner reader = new Scanner(System.in);
	System.out.println("please enter an integer");
	int1 = reader.nextInt();
	
	//reader.close();
	
	System.out.println("please enter another integer");
	int2 = reader.nextInt();
	
	//reader.close();
	
	System.out.println("Now you must enter one of the following: +, -, *, or /");
	operator = reader.next();
	
	reader.close();
	
	switch (operator)
	{
	case "+":
	{
	System.out.println(int1 + int2);
	break;
	}
	case "-":
	{
	System.out.println(int1 - int2);
	break;
	}
	case "*":
	{
	System.out.println(int1 * int2);
	break;
	}
	case "/":
	{
	System.out.println(int1 / int2);
	break;
	}
	default: 
	{
	System.out.println("What kind of rubbish operator is this?");
	break;
	}
	//System.out.println(someint + " " + somedouble + " " + somestring);
	}

}
	
}
