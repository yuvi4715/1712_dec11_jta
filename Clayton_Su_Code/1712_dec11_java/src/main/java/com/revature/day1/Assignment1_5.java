package com.revature.day1;

import java.util.Scanner;

public class Assignment1_5 {
	
	static int add(int a, int b)
	{
		int sum = a+b;
		return sum;
	}
	
	static int subtract(int a, int b)
	{
		int diff = a-b;
		return diff;
	}
	
	static double multiply(double a, double b)
	{
		double product = a*b;
		return product;
	}
	
	static double divide(double a, double b)
	{
		double quot = a/b;
		return quot;
	}
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		
		System.out.println("Enter another number: ");
		int x = reader.nextInt();
		
		System.out.println(n);
		System.out.println(x);
		System.out.println("\n");
		
		System.out.println("add");
		System.out.println(add(n,x));
		System.out.println("subtract");
		System.out.println(subtract(n,x));
		System.out.println("multiply");
		System.out.println(multiply(n,x));
		System.out.println("divide");
		System.out.println(divide(n,x));
		
		reader.close();
	}
}
