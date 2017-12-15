package com.assignment1;

public class Problem45 {

	static boolean isPrime(int x)
	{
		for(int i = 2; i <= x/2; i++)
		{
			if(x % i == 0)
			{
				System.out.println("Nope");
				return false;
			}
		}
		System.out.println("Prime number");
		return true;
	}
	
	public static void main(String[] args) {
		int n = 5;
		isPrime(n);
	}

}
