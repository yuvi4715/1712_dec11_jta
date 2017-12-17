package part10_EasyExercises;

import java.util.Scanner;

// Number 35 - User inputs an integer, double, and a string.
//				The program will show the user what he/she entered.
public class KeyboardScanner {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter An Integer: ");
		int i = sc.nextInt();
		
		System.out.print("Enter A Double: ");
		double d = sc.nextDouble();
		
		Scanner sc2 = new Scanner(System.in);
		System.out.print("Enter A String: ");
		String s = sc2.nextLine();
		
		System.out.println();
		System.out.println("You Entered " + i + " as your Integer.");
		System.out.println("You Entered " + d + " as your Double.");
		System.out.println("You Entered " + s + " as your String.");
	}

}
