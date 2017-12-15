package com.assignment1.Problem32;

import java.util.Scanner;

public class KeyboardScanner {

	public static void read()
	{
		int x =0;
		double d = 0;
		String s = "";
		System.out.println("Input an int:");
		Scanner scan = new Scanner(System.in);
		x = scan.nextInt();
		
		System.out.println("Input an double:");
		d = scan.nextDouble();
		
		System.out.println("Input an String:");
		s = scan.nextLine();
		
		

	}
	
	public static void main(String[] args) {
		
	}

}
