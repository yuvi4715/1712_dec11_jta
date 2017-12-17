package com.revature.coreJava;

//Nathan Poole
//Question Two
//Write a program to search for the greatest of 
//three numbers using Short-circuit Operators and print the result. 

public class QuestionTwo {
	
	public static void main(String[] args) {
		int a = 13, b = 5, c = 7;
		
		if( a>b && a>c ) System.out.print(a);	//if a is the greatest print a
		else {
			if (b>a && b>c) System.out.print(b);//else if b is the greatest print b
			else System.out.print(c);			//else c must be the greatest so print it
		}
		System.out.println(" is the greatest!");
	}
}
