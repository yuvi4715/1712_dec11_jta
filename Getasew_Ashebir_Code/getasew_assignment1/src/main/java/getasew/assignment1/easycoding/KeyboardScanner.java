package getasew.assignment1.easycoding;
import java.util.Scanner;
/*
 * 35.Write a program called GradesStatistics, 
 * which reads in n grades (of int between 0 and 100, inclusive) and 
 * displays the average, minimum, maximum, and standard deviation. 
 *Your program shall check for valid input. You should keep the grades 
 *in an int[] and use a method for each of the computations.

 */
public class KeyboardScanner {
	public static void main(String[] args) {
		printString();
		printInteger();
		printDouble();
	}
	public static void printString() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string input");
		//read a line of text from user
		String input = scanner.nextLine();
		//display the input 
		System.out.println("input= "+ input);
		
	}
	public static void printInteger() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a integer input");
		//read a line of text from user
		String input = scanner.nextLine();
		//parse the string into integer
		int number = Integer.parseInt(input);
		//display the input 
		System.out.println(number);
		
	}
	public static void printDouble() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a double input");
		//read a line of text from user
		String input = scanner.nextLine();
		//parse input to double
		double d = Double.parseDouble(input);
		
		//display the input 
		System.out.println(d);
		
	}
}
