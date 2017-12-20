package bonusExercises;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberGuess {
	static int random;
	static int trials;
	static Scanner sc;
	static boolean playing;
	/*
	 * Write a program called NumberGuess to play the number guessing game. 
	 * The program shall generate a random number between 0 and 99. The player 
	 * inputs his/her guess, and the program shall response with "Try higher", 
	 * "Try lower" or "You got it in n trials" accordingly.
	 */
	public static void main(String[] args) {
		runGame();
	}
	
	public static void runGame() {
		sc = new Scanner(System.in);
		random = (int) (Math.random() * 100);
		System.out.println("Guess a number between 0 and 99");
		playing = true;
		trials = 0;
		while (playing) {
			trials++;
			try {
				getUserInt();
			}
			catch (InputMismatchException e) {
				System.err.println("That's not an integer! Try again");
				sc.next(); // empty the scanner so we avoid infinite loop
				trials++;
				getUserInt();
			}
		}
		sc.close();
	}
	
	public static void getUserInt() throws InputMismatchException {
		int guess = sc.nextInt();
		if (guess < 0 || guess >= 100)
			System.out.println("That's outside the range");
		if (guess < random) {
			System.out.println("Try higher!");
		}
		else if (guess > random) {
			System.out.println("Try lower!");
		}
		else {
			System.out.println("You got it in " + trials + " trials");
			playing = false;
		}
	}
}
