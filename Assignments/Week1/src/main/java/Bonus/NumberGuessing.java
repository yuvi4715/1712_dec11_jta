package Bonus;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		run();
	}
	
	private static void run() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Guess the number in place (0-99): ");
		int number = reader.nextInt();
		Random rand = new Random();
		int randomNumber = rand.nextInt(99);
		
		if(number < randomNumber) {
			System.out.println("Try Higher, the answer was: " + randomNumber);
		}
		if(number > randomNumber) {
			System.out.println("Try lower, the answer was: " + randomNumber);
		}
		if(number == randomNumber) {
			System.out.println("You got the right number!: " + randomNumber);
		}	
	}
}
