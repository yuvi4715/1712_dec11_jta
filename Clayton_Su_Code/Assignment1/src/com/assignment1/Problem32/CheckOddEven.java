package com.assignment1.Problem32;

public class CheckOddEven {

	public static void checkOddEven(int x)
	{
		if(x % 2 == 0)
			System.out.println("Even Number");
		else
			System.out.println("Odd Number");
	}
	
	public static void main(String[] args) {
		int number = 1;
		
		checkOddEven(number);
		
		number = 0;
		checkOddEven(number);
		
		number = 2;
		checkOddEven(number);
	}

}
