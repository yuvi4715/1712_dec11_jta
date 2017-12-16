package bonusExercises;
import java.util.*;

public class NumberGuess {

	static void game(int numGuesses) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		int numberToBeGuessed = random.nextInt(99);
		System.out.println("Guess a number between 0 and 99");
		do {
			while (!input.hasNextInt()) {
				System.out.println("Input must be an integer");
				input.next();
			}
			int guess = input.nextInt();
			if (numberToBeGuessed == guess) {
				System.out.println("Congratulations! You won!");
				numGuesses = 0;
			} else {
				System.out.println(guess +" is not correct.");
				if (numGuesses - 1 == 0) {
					System.out.println("Thank you for playing!");
					input.close();
				} else if (numGuesses - 1 == 1) {
					System.out.println("You have " + (numGuesses - 1) + " guess left.");

				} else {
					System.out.println("You have " + (numGuesses - 1) + " guesses left.");
				}
				numGuesses--;
			}
		} while (numGuesses > 0);
	}
	
	public static void main(String[] args) {
		game(3);
	}
	
}
