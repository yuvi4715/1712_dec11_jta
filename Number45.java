package com.revature.day1;

import java.util.Scanner;

public class Number45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int n = 0;
	
		
		Scanner reader = new Scanner(System.in);
		System.out.println("enter a number to see if prime or not");
		n = reader.nextInt();
		
		for(int i = 2; i <= n / 2; i++) {
			if(n % i == 0) {
				System.out.println("this number is not prime");
		} else {
			System.out.println("this number is prime");
		}
	}

}
}
