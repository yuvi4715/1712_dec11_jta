package easyCodingExercises;

import java.util.InputMismatchException;
import java.util.Scanner;

import collectionsExercises.Main;


public class KeyboardScanner {

	private Scanner input;
	private boolean intInput = true;
	private int validatedInt;
	private double validatedDouble;
	private boolean doubleInput = true;
	private String validatedString;
	private boolean stringInput = true;
	
	public KeyboardScanner() {
		this.getUserInput();
	}
	
	public void inputInt() {
		this.input = new Scanner(System.in);
		do {
			System.out.println("Enter an integer: ");
			while (!input.hasNextInt()) {
				System.out.println("Input must be an integer.");
				input.next();
			}
			this.validatedInt = input.nextInt();
			intInput = false;
		} while (intInput);
	}
	
	public void inputDouble() {
		this.input = new Scanner(System.in);
		do {
			System.out.println("Enter a double: ");
			while (!input.hasNextDouble()) {
				System.out.println("Input must be a double.");
				input.next();
			}
			this.validatedDouble = input.nextDouble();
			doubleInput = false;
		} while (doubleInput);
	}
	
	public void inputString() {
		this.input = new Scanner(System.in);
		do {
			System.out.println("Enter a string: ");
			while (!input.hasNextLine()) {
				System.out.println("Input must be a string.");
				input.next();
			}
			this.validatedString = input.nextLine();
			stringInput = false;
		} while (stringInput);
	}
	
	public void getUserInput() {
		this.inputInt();
		this.inputDouble();
		this.inputString();
		System.out.println("Your input:");
		System.out.println("Integer: " + this.validatedInt);
		System.out.println("Double: " + this.validatedDouble);
		System.out.println("String: " + this.validatedString);
	}
	
	public static void main(String[] args) {
		new KeyboardScanner();
	}
	
}
