package com.revature.day1;

public class Number40 {
	
	static int fib(int f)
	{
	int a, b, c;
	a = 0;
	b = 1;
	c = 2;
	
	for(int i = 1; i <= f; i++)
	{
		c = a + b;
		System.out.println(a);
		a = b;
		b = c;
	}
	return f;
}
	
	
	static int Recfib(int n) // recursive fib method
	{
		if (n <= 1)
			return n;
		return fib(n-1) + fib(n-2);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		//System.out.println(fib(n));
		System.out.println(Recfib(n));
	}

}
