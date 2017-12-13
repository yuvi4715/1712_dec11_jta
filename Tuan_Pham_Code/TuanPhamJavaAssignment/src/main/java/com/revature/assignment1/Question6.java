package com.revature.assignment1;

//6.	Create an example for each control statement.
public class Question6 {

	// method demonstrating the if control statement
	public void ifStatement() {
		int a = 2;
		
		if (a >= 0) {
			System.out.println(a + " is positive!");
		} 
		else {
			System.out.println(a + " is negative!");
		}
	}
	
	// method demonstrating the switch-case control statement
	public void switchStatement() {
		int meal = 3;
		
		switch(meal) {
		case 1:
			System.out.println("Ordering 1 meal");
			break;
		case 2: 
			System.out.println("Ordering 2 meals");
			break;
		case 3:
			System.out.println("Ordering 3 meals");
			break;
		default:
			System.out.println("Not ordering any meals");
		}
	}
	
	// method demonstrating the for control statement
	public void forStatement() {
		int count = 4;
		
		for (int i = 1; i < count; i++) {
			System.out.println(i);
		}
	}
	
	// method demonstrating the while control statement
	public void whileStatement() {
		int count = 10;
		while (count > 0) {			
			System.out.println(count);
			count /= 2;
		}
	}
	
	// method demonstrating the do-while control statement
	public void doWhileStatement() {
		int count = 3;
		
		do {
			System.out.println(count);
			count--;
		} while (count > 0);
	}
	
	// method demonstrating the break control statement
	public void breakStatement() {
		int count = 10;
		for (int i = 1; i < count; i++) {
			System.out.println(i);
			if (i == 3) {
				break;
			}
		}
	}
	
	// method demonstrating the continue control statement
	public void continueStatement() {
		int a = 10;
		while (a > 0) {
			System.out.println(a);
			a /= 2;
			
			if (a == 1) continue;
		}
	}
	
	public static void main(String[] args) {
		Question6 q6 = new Question6();
		q6.ifStatement();
		q6.switchStatement();
		q6.forStatement();
		q6.whileStatement();
		q6.doWhileStatement();
		q6.breakStatement();
		q6.continueStatement();

	}

}
