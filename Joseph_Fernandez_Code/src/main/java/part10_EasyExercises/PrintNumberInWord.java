package part10_EasyExercises;

import java.util.Scanner;

// Number 34 - User inputs a number between 1 and 9. The program returns the integer in a 
//				string format.
public class PrintNumberInWord {

	public static void main(String[] args) {

		System.out.print("Enter A Number: ");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
	// Nested-If Statement
		System.out.println();
		System.out.println("Nested-If Statement");
		
		if(x == 1) {
			System.out.println("ONE");
		} else if(x == 2) {
			System.out.println("TWO");
		} else if(x == 3) {
			System.out.println("THREE");
		} else if(x == 4) {
			System.out.println("FOUR");
		} else if(x == 5) {
			System.out.println("FIVE");
		} else if(x == 6) {
			System.out.println("SIX");
		} else if(x == 7) {
			System.out.println("SEVEN");
		} else if(x == 8) {
			System.out.println("EIGHT");
		} else if(x == 9) {
			System.out.println("NINE");
		} else {
			System.out.println("OTHER");
		}
		
	// Switch-Case Statement
		System.out.println();
		System.out.println("Switch-Case Statment");
		
		switch(x) {
			case 1:
				System.out.println("ONE");
				break;
			case 2:
				System.out.println("TWO");
				break;
			case 3:
				System.out.println("THREE");
				break;
			case 4:
				System.out.println("FOUR");
				break;
			case 5:
				System.out.println("FIVE");
				break;
			case 6:
				System.out.println("SIX");
				break;
			case 7:
				System.out.println("SEVEN");
				break;
			case 8:
				System.out.println("EIGHT");
				break;
			case 9:
				System.out.println("NINE");
				break;
			default:
				System.out.println("OTHER");
				break;
		}
	}
}
