package com.assignment1.Problem32thru37;

import java.util.Scanner;

public class KeyboardScanner {

	public static void read()
	{
		int x = 0;
		double d = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Input an int:");
		x = scan.nextInt();
		
		System.out.println("Input an double:");
		d = scan.nextDouble();
		
		scan.nextLine(); //hack to prevent 
							//nextLine from skipping
		
		System.out.println("Input an String:");
		String s = scan.nextLine();
		
		System.out.println(x);
		System.out.println(d);
		System.out.println(s);
		scan.close();
	}
	
	public static void main(String[] args) {
		read();
	}

}
