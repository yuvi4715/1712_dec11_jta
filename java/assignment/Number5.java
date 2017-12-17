package com.revature.day1;

public class Number5 { //class created
	
	//variables
	int a = 10, b = 2;
	
	//defining methods to follow
	
	int addition()
	{
		
		System.out.println(a + b);
		return a + b;
	}
	
	int subtraction()
	{
		System.out.println(a - b);
		return a - b;
	}
	
	int multiply()
	{
		System.out.println(a * b);
		return a * b;
	}
	
	float division()
	{
		System.out.println(a / b);
		return a / b;
	}
	
	//setters and getters needed so that data can be parsed to class
	
	
	//main falls within the class, and runs first

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//create instance of new class for use in main:
		Number5 thing = new Number5();
		
		thing.addition();
		thing.subtraction();
		thing.multiply();
		thing.division();
	
	

	}
}
