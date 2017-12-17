package com.revature.syntax;

/*
 * Nathan Poole
 * Question Six
 * Create an example for each control statement.
 */


public class QuestionSix {
	public static void main(String[] args) {
		int choice = 2;
		boolean flipFlop[] = {true, false};
		
		
		for(boolean x: flipFlop) {//	extended for loop
			if(x) System.out.println("This prints when true.");// if/else
			else System.out.println("This prints when false.");
		}
		
		switch(choice) { //	Switch statement
		case 1: 
			System.out.println("This will print when choice is 1.");
			break; //break statement
		case 2:
			System.out.println("This will print when choice is 2.");
			break;
		default:
			System.out.println("default runs when choice dosnt match a case.");
			break;
		}
		
		int i=0;
		while(i<5) { //	while loop
			System.out.print(i++);
		}
		
		do { //do while loop
			System.out.println("This prints even though i is already five.");
		} while(i<5);
			
		for(int j = 0; j<=5; j++) { // Regular for loop
			if(j==3) {
				System.out.println("continue with out printing j.");
				continue; // continue
			}
			if(j==4) {
				System.out.println("Break out of loop even though j is <=5.");
				break; // another break( in a loop this time)
			}
			System.out.println(j);
		}
		
		System.out.println(returning());
		
	}

	private static String returning() {
		// TODO Auto-generated method stub
		return "I have Returned!"; //return statemtn
	}
}
