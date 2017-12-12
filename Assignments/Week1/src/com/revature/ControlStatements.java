package com.revature;

public class ControlStatements {

	void controls() {
		int a = 5, b = 20, c = 5;
		System.out.println("Displaying if-else statement");
		
		if( a < b) {
			System.out.println("a is less than b");
		}
		else {
			System.out.println("a is greater than b");
		}
		
		System.out.println("Displaying for statement");
		for(int x =0; x < a; x++) {
			System.out.println(x);
		}
		
		System.out.println("Displaying while statement");
		while(a < 10) {
			System.out.println(a++);
		}
		
		System.out.println("Displaying do-while statement");
		do {
			System.out.println(b++);
		}while(b < 25);
		
		
		System.out.println("Displaying switch statement");

		switch (c) {
		case 5:
			System.out.println("C is 5!");
			break;
		default:
			System.out.println("That number is not recognized!");
			break;
		}
	}
}
