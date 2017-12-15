package com.assignment1.problem5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		
		System.out.println("Enter another number: ");
		int x = reader.nextInt();
		
		reader.close();
		
		
		int a = Calculate.add(n, x);
		int b = Calculate.subtract(n, x);
		double c = Calculate.multiply(n, x);
		double d = Calculate.divide(n, x);
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
	}

}
