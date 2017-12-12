package com.revature;

public class ShortCircuit {
	
	private int a = 6;
	private int b = 7;
	private int c = 5;
	
	//here i am doing a POC for short circuit operators, some may fire some may not.
	
	void message() {
		
		if(a < b && b < c) {	
			System.out.printf("C is the greatest number with a value of %d\n",c);
		}
		
		if(a > b && b <c) {
			System.out.printf("A is the greatest number with a value of %d\n",a);
		}
		
		if(a < b && b > c) {
			System.out.printf("B is the greatest number with a value of %d\n",b);
		}
		
		if(a < b && b > c || a < b && b <c) {
			System.out.printf("B and C are the greater numbers! With values of %d and %d\n",b,c);

		}
				
	}

}
