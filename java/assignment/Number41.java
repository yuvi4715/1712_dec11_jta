package com.revature.day1;

public class Number41 {
	
	public void FeelTheFizz()
	{
		int x = 0;
		
		for (x = 1; x < 51; x++)
		{
			if (x % 3 == 0 && x % 5 == 0)
			{
				System.out.println("FizzBuzz");
			} else if (x % 5 == 0)
			{
				System.out.println("Buzz");
			} else if (x % 3 == 0)
			{
				System.out.println("Fizz");
			} else {
				System.out.println(x);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Number41 example = new Number41();

example.FeelTheFizz();
	}

}
