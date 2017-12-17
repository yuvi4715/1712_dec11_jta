package com.revature.coreJava;

//Nathan Poole
//Question Three
//Write a program –declare two variables a & b and 
//initialize them to true and false respectively. 
//Get the output of the following computations:
//	!a
//	a | b
//	(!a & b) | (a & !b)


public class QuestionThree {
	public static void main(String[] args) {
		boolean a = true, b = false;
		
		System.out.println(!a);
		System.out.println(a|b);
		System.out.println((!a&b)|(a&!b));
	}
}
