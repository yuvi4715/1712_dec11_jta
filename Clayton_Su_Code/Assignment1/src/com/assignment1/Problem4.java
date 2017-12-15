package com.assignment1;



public class Problem4 {
	
	int add(int a, int b)
	{
		int sum = a+b;
		return sum;
	}
	int subtract(int a, int b)
	{
		int diff = a-b;
		return diff;
	}
	double multiply(double a, double b)
	{
		double x = a*b;
		return x;
	}
	double divide(double a, double b)
	{
		double x = a/b;
		return x;
	}
	
	
	
	public static void main(String[] args) {
		int x = 12;
		int y = 4;
		
		Problem4 p1 = new Problem4(); 
		System.out.println(p1.add(x, y));
		System.out.println(p1.subtract(x, y));
		System.out.println(p1.multiply(x, y));
		System.out.println(p1.divide(x, y));

		
	}
}
