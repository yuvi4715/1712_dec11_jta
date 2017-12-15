package com.assignment1;

public class Problem43 {
	
	static void armstrong(int x)
	{
		int sum = 0;
		int temp = 0;
		int a = 0;
		int n = x;
		
		temp = x;
		
		while(n > 0)
		{
			//gets the last digit
			// 153 % 10 = 3
			a = n%10;
			
			//add to sum the cubed digit
			// 0 + 3^3
			sum = sum+(a*a*a);
			
			//remember that integer division only
				//has whole number and no remainder
			// 153 / 10 = 15, not 15.3
			n = n/10;	
		}
		
		if (temp == sum)
			System.out.println("Armstrong number");
		else
			System.out.println("Not Armstrong");
	}

	public static void main(String[] args) {
//		 Armstrong number is a number that is equal 
//		 to the sum of cubes of its digits 
//		 for example 0, 1, 153, 370, 371, 407 etc.
		armstrong(153);
		
		
	}

}
