package com.revature.assignment1;

//3.	Write a program –declare two variables a & b and initialize them to true and false respectively. 
//      Get the output of the following computations:
//      !a
//      a | b    
//      (!a & b) | (a & !b)

public class Question3 {

	static boolean a = true;
	static boolean b = false;
	
//  !a
	public void computeNotA() {
		System.out.println(!a);
	}
	
//  a | b    
	public void computeAOrB( ) {
		System.out.println(a | b);
	}
	
//  (!a & b) | (a & !b)
	public void computeNotAAndBOrAAndNotB() {
		System.out.println((!a & b) | (a & !b));
	}
	public static void main(String[] args) {
		Question3 q3 = new Question3();
		q3.computeNotA();
		q3.computeAOrB();
		q3.computeNotAAndBOrAAndNotB();
	}
}
