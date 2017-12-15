package com.assignment1;

public class Problem41 {

	public static void fizzBuzz()
	{
		for(int i = 1; i <= 50; i++)
		{
			if(i%3 == 0 && i%5 == 0)
				System.out.println("FizzBuzz");
			else if(i % 3 == 0)
				System.out.println("Fizz");
			else if (i % 5 == 0)
				System.out.println("Buzz");
			else
				System.out.println(i);
			
		}
	}
	public static void main(String[] args) {
		fizzBuzz();
	}

}
