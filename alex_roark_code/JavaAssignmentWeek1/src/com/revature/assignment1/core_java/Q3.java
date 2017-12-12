package com.revature.assignment1.core_java;

public class Q3 {

	public static void main(String[] args) {

		boolean a = true;
		boolean b = false;
		
		System.out.println("The output of !a is " + (!a));
		System.out.println("The output of a | b is " + (a | b));
		System.out.println("The output of (!a & b) | (a & !b) is " + ((!a & b) | (a & !b)));
	}

}
