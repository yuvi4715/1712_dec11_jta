package EasyCodingExercises;

import java.util.*;

public class CheckOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {

			new CheckOdd().checkODD();
		}
	}


	public void checkODD() {
		Random rand = new Random();

		int number = (rand.nextInt(50) + 1);
		if ((number % 2) == 0) {
			System.out.printf("Even number: %d\n", number);
		}
		if ((number % 2) >= 1) {
			System.out.printf("Odd number: %d\n", number);

		}

	}

}
