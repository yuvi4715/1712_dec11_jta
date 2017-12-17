package part02_Syntax;

import java.util.Scanner;

// Question 06
public class ControlStatements {

	public static void main(String[] args) {

		System.out.println("-------- Selection Statement --------");
		SelectionStatement();
		System.out.println("-------- Iteration Statement --------");
		IterationStatement();
		System.out.println("-------- Jump Statement --------");
		JumpStatement();
		
	}

	// Selection Statement - if, if-else, if-else if, switch statements
	public static void SelectionStatement() {

		System.out.println("if-else statement");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Age: ");
		int age = sc.nextInt();
		
		if(age >= 21) {
			System.out.println("You are legal to drive, smoke, and drink.");
		} else if (age >= 18) {
			System.out.println("You are legal to drive and smoke.");
		} else if (age >= 16) {
			System.out.println("You are legal to drive.");
		} else {
			System.out.println("You are not legal to do anything yet.");
		}
	}

	// Iteration Statement - while, for, do-while, for-each statements
	public static void IterationStatement() {

		System.out.println("do-while loop");
		int x = 0;
		do {
			System.out.println("Value: " + x);
			x++;
		} while (x < 10);	
	}

	// Jump Statement - break, continue, return statements
	public static void JumpStatement() {

		System.out.println("break statement");
        for (int inc = 0; inc < 25; inc++)  
        {  
            System.out.println("Inc is : " + inc);  
            if (inc == 15) {
                break;  
            }
        }  
	}
}