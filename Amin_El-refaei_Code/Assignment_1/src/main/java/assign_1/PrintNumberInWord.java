package assign_1; // This class contains the code for number 34

import java.util.Scanner; // import the sanner class to get input from the user

public class PrintNumberInWord {

	public static void main(String[] args) {
		ifStatements(); // statically call the ifStatements() method
		switchStatements(); // statically call the switchStatements() method
	}

	public static void ifStatements() {
		Scanner num = new Scanner(System.in); // create a scanner to accept input from the user

		int number = num.nextInt(); // create an int called number which is assigned the value that the user enters
									// into the scanner

		if (number == 1) { // if number is 1, print ONE
			System.out.println("ONE");
		} else if (number == 2) {
			System.out.println("TWO");
		} else if (number == 3) {
			System.out.println("THREE");
		} else if (number == 4) {
			System.out.println("FOUR");
		} else if (number == 5) {
			System.out.println("FIVE");
		} else if (number == 6) {
			System.out.println("SIX");
		} else if (number == 7) {
			System.out.println("SEVEN");
		} else if (number == 8) {
			System.out.println("EIGHT");
		} else if (number == 9) {
			System.out.println("NINE");
		} else { // if number is any number outside of 1-9, print OTHER
			System.out.println("OTHER");
		}

		num.close(); // close the scanner
	}

	public static void switchStatements() {
		Scanner num = new Scanner(System.in); // create a scanner to accept input from the user

		int number = num.nextInt(); // create an int called number which is assigned the value that the user enters
									// into the scanner

		switch (number) { // switch statement
		case 1: // if user enters 1, print ONE
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
		default: // if the user enters anything other than 1-9, print OTHER
			System.out.println("OTHER");
			break;
		}

		num.close(); // close the scnaner
	}

}
