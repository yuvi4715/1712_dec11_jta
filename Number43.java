package com.revature.day1;

import java.util.Scanner;

public class Number43 {
	
	public void checkArm(int number)
	{
		int c = 0, a, temp;
		
		int n = number;
		
		temp = n;
		
		while(n > 0)
		{
			a = n % 10;
			n = n/10;
			
			c = c + (a*a*a);
		}
		
		if(temp == c)
		{
		System.out.println("armstrong number");
		} else {
			System.out.println("Not an armstrong number");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int someint = 0;
		
		Scanner reader = new Scanner(System.in);
		System.out.println("please enter an integer to check for Armstrongness");
		someint = reader.nextInt();
		
		reader.close();
		
		Number43 example = new Number43();
		example.checkArm(someint);
		
	}

}
