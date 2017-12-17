package assign_1; // this class is for number 35 of assignment 1

import java.util.Scanner;

public class KeyboardScanner {

	public static void main(String[] args) {
		
		int x; // created variables x, y, and word
		double y;
		String word;
		
		Scanner scan = new Scanner(System.in); // created a scanner to take input from the user
		
		x = scan.nextInt(); // assigning whatever the user enters to variable x
		y = scan.nextDouble();
		word = scan.next();
		
		scan.close(); // closing the scanner
		
		System.out.println("The int that you entered is " + x);
		System.out.println("The double that you entered is " + y);
		System.out.println("The String that you entered is " + word);
		
		
	}

}
