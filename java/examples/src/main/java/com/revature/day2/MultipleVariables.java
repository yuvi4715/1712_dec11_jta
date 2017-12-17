package com.revature.day2;

public class MultipleVariables {

	public static void main(String[] args) {
		MultipleVariables mv = new MultipleVariables();
		mv.myVariable(10);
		mv.myVariable(10,20);
		mv.myVariable(10,20,30);
		mv.myVariable(10,20,30,40);
		mv.myVariable(10,2,334,34,34,34,3,4534);
	}
	
	//multiple variables have to be the last argument in a method
	void myVariable(int x, int ...y) {
		System.out.println("value of x " + x);
		for (int i=0; i<y.length; i++) {
			System.out.println("value of y " + y[i]);
		}
		
//		for (int i:y) {
//			System.out.println("value of y " + i);
//		}
	}
}
