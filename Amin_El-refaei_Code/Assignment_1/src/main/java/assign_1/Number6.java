package assign_1;

import java.util.Scanner;

public class Number6 {

	public static void main(String[] args) {
		ifExample(); // statically calling all methods to run
		ifElseExample();
		switchExample();
		forLoopExample();
		whileLoopExample();
		doWhileExample();
		breakDemo();
		continueDemo();
	}

	// if statement demo
	public static void ifExample() {
		int x = 15, y = 5;// creating 2 instance variables x and y, and assigning them values

		if (x > y) { // if x is larger than y, print that
			System.out.println("x is larger than y");
		}
		if (x < y) { // if y is larger than x, print that
			System.out.println("y is larger than x");
		}

	}

	// if-else statement demo
	public static void ifElseExample() {

		int x = 12, y = 25;// creating 2 instance variables x and y, and assigning them values
		if (x > y) {
			System.out.println("x is larger than y"); // if x is larger than y, print that
		} else {
			System.out.println("y is larger than x"); // otherwise, print y is larger than x
		}
	}

	// switch-case demo
	public static void switchExample() {

		Scanner num = new Scanner(System.in); // creating a scanner called num to take input from the keyboard to assign
												// to x1 variable
		int x1; // create an int variable x1 without giving it a value

		System.out.println("Enter a number between 0-9"); // ask the user to enter a value between 0 and 9 to assign to
															// x1 variable
		x1 = num.nextInt();

		switch (x1) {
		case 0:
			System.out.println("Zero"); // if user enters 0, print 0 and break
			break;
		case 1:
			System.out.println("One"); // if user enters 1, print 1 and break
			break;
		case 2:
			System.out.println("Two"); // if user enters 2, print 2 and break
			break;
		case 3:
			System.out.println("Three"); // if user enters 3, print 3 and break
			break;
		case 4:
			System.out.println("Four"); // if user enters 4, print 4 AND 5, then break
		case 5:
			System.out.println("Five"); // if user enters 5, print 5 and break
			break;
		default:
			System.out.println("The number entered is greater than 5"); // if user enters a number higher than 5, print
																		// the number is greater than 5 and break

			num.close(); // close scanner
		}

	}

	// for loop demo
	public static void forLoopExample() {
		for (int n = 0; n < 5; n++) { // created a for loop with integer n carrying a value of 0. increment n by 1
										// each time you gpo throght loop until n reaches 5
			System.out.println(n); // print the value of n each time through the loop
		}
	}

	// while loop demo
	public static void whileLoopExample() {
		int num = 5; // created an int variable with the value 5

		while (num < 12) { // while int num is less than 12, continue to go through the loop
			System.out.println(num); // print num each time through the loop
			num++; // increment num each time through the loop
		}
	}

	// do-while loop demo
	public static void doWhileExample() {
		int num = 5; // created an int variable with the value 5
		do {
			System.out.println(num); // print num each time through the loop
			num++; // increment num each time through the loop
		} while (num < 12); // iterate through the loop while num is less than 12

	}

	// break demo
	public static void breakDemo() {
		for (int r = 1; r < 4; r++) { // created a for loop with integer r carrying a value of 1. increment r by 1
										// each time you go through loop until r reaches 4
			if (r == 3) // if r == 3, break
				break;
			System.out.println(r); // print the value of r
		}
		System.out.println("The loop is complete!"); // print the loop is complete!
	}

	// continue demo
	public static void continueDemo() {
		for (int r = 1; r < 4; r++) { // created a for loop with integer r carrying a value of 1. increment r by 1
										// each time you go through loop until r reaches 4
			if (r == 3) // if r == 3, continue
				continue;
			System.out.println(r); // print the value of r
		}
	}

}
