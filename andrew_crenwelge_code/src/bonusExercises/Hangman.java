package bonusExercises;

import java.io.Console;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Hangman {
	private static Scanner read;
	private static String word;
	private static String currentGuess;
	private static String p1;
	private static String p2;
	private static boolean gameIsEnded;
	private static int hangmanParts=0;
	private static int guesses=0;
	private static final int maxGuesses = 6;
	private static Set<String> guessedChars = new TreeSet<>();

	public static void main(String[] args) {
		/*
		 * Write a Java console application for the classic Hangman game. Allow on
		 * player to enter a word that the other player attempts to guess (use
		 * Console.readPassword to obscure the text). For each incorrect answer, draw a
		 * piece of the Hangman on the console. Show a tally of all previously selected
		 * letters too
		 */
		
		startGame();
	}
	
	public static void startGame() {
		read = new Scanner(System.in);
		System.out.println("Welcome to Hangman. Player 1 will think of a word that Player 2 tries to guess");
		System.out.print("Player 1, please enter your name: ");
		p1 = read.next();
		System.out.print("Player 2, please enter your name: ");
		p2 = read.next();
		System.out.println("Ok, let's begin! "+p1+" , enter the word you want "+p2+" to guess");
		Console c = System.console();
		if (c != null) {
			word = new String(c.readPassword());
		}
		else {
			word = read.next();
		}
		System.out.println("The mystery word is " + word.length() + " letters long");
		System.out.println("Alright, "+p2+" it's time to start guessing");
		while(!gameIsEnded) {
			getGuess();
		}
	}
	
	public static void getGuess() {
		System.out.println("==================================");
		if (guesses==0)
			System.out.print(p2+", make your first guess: ");
		else
			System.out.print(p2+", please make another guess: ");
		currentGuess = read.next();
		guesses++;
		if (currentGuess.length() != 1) {
			if (currentGuess.equals(word)) {
				System.out.println("You guessed it! Congratulations, " + p2 + ", you win!");
				System.out.println("The mystery word was: \t" + word);
				gameIsEnded = true;
			}
			else {
				System.err.println("Sorry, that's not it");
				addHangmanPart();
			}
		}
		else {
			guessedChars.add(currentGuess);
			if (word.contains(currentGuess)) {
				if (wordHasBeenGuessed()) {
					System.out.println("You guessed it! Congratulations, " + p2 + ", you win!");
					System.out.println("The mystery word was: \t"+word);
					gameIsEnded = true;
				}
				else {
					System.out.println("Correct! The word has at least one '" + currentGuess+"'");
				}
			}
			else {
				System.err.println("Sorry! The word does not contain a '" + currentGuess + "'");
				addHangmanPart();
			}
		}
		if (!gameIsEnded) {
			printObscuredWord();
			System.out.println("Letters you have already guessed: " + guessedChars);
		}
	}

	public static boolean wordHasBeenGuessed() {
		for (String s : word.split("")) {
			if (!guessedChars.contains(s))
				return false;
		}
		return true;
	}
	
	public static void addHangmanPart() {
		hangmanParts++;
		System.err.println("You have "+(maxGuesses-hangmanParts) +" guesses remaining");
		// draw hangman parts here
		if (hangmanParts == 6) {
			System.out.println(
					"   ___   \n" +
					"  |   |  \n" +
					"  |  \\o/ \n" +
			        "  |   |  \n" +
					"__|__/ \\   "
					);
			System.err.println("Sorry "+p2+", you lose!");
			System.out.println("The mystery word was " + word);
			gameIsEnded = true;
		}
		else if (hangmanParts == 5) {
			System.out.println(
					"   ___   \n" +
					"  |   |  \n" +
					"  |  \\o/\n" +
			        "  |   |  \n" +
					"__|__/     "
					);
		}
		else if (hangmanParts == 4) {
			System.out.println(
					"   ___   \n" +
					"  |   |  \n" +
					"  |  \\o/ \n" +
			        "  |   |  \n" +
					"__|__      "
					);
		}
		else if (hangmanParts == 3) {
			System.out.println(
					"   ___   \n" +
					"  |   |  \n" +
					"  |   o/ \n" +
			        "  |   |  \n" +
					"__|__      "
					);
		}
		else if (hangmanParts == 2) {
			System.out.println(
					"   ___   \n" +
					"  |   |  \n" +
					"  |   o \n" +
			        "  |   |  \n" +
					"__|__      "
					);
		}
		else if (hangmanParts == 1) {
			System.out.println(
					"   ___   \n" +
					"  |   |  \n" +
					"  |   o  \n" +
			        "  |      \n" +
					"__|__      "
					);
		}
	}
	
	public static void printObscuredWord() {
		System.out.println("Mystery word: \t");
		for (int i=0;i<word.length();i++) {
			String character = word.substring(i, i+1);
			if (guessedChars.contains(character))
				System.out.print(character);
			else
				System.out.print("*");
		}
		System.out.println();
	}
}
