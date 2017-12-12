package com.revature.assignment1.syntax;

public class Q6 {

	public static void main(String[] args) {

		boolean booleanVariable = true;
		if (booleanVariable) {
			System.out.println("The condition is true!");
		}

		booleanVariable = false;
		if (booleanVariable) {
			System.out.println("The condition is true!");
		} else {
			System.out.println("The condition is false!");
		}

		int number = 3;
		String numberSpelled;
		switch (number) {
		case 1:
			numberSpelled = "one";
			break;
		case 2:
			numberSpelled = "two";
			break;
		case 3:
			numberSpelled = "three";
			break;
		case 4:
			numberSpelled = "four";
			break;
		case 5:
			numberSpelled = "five";
			break;
		default:
			numberSpelled = "not yet in the program!";
		}
		System.out.println(number + " spelled is " + numberSpelled);

		int result = 1;
		for (int i = 0; i < 10; i++) {
			result = result * 2;
		}
		System.out.println("The final result is " + result);

		int numberTimesToIterate = 10;
		int numberTimesIterated = 0;
		while (numberTimesToIterate > 0) {
			numberTimesToIterate--;
			numberTimesIterated++;
		}
		System.out.println("The number of times this while loop iterated is " + numberTimesIterated);

		numberTimesToIterate = 20;
		numberTimesIterated = 0;
		do {
			numberTimesToIterate--;
			numberTimesIterated++;
		} while (numberTimesToIterate > 0);
		System.out.println("The number of times this do-while loop iterated is " + numberTimesIterated);

		numberTimesToIterate = 30;
		numberTimesIterated = 0;
		while (numberTimesToIterate > 0) {
			numberTimesToIterate--;
			numberTimesIterated++;
			if (numberTimesIterated == 20) {
				break;
			}
		}
		System.out.println("This loop only iterated " + numberTimesIterated + " times");

		numberTimesToIterate = 40;
		numberTimesIterated = 0;
		int numberIterationsCounted = 0;
		while (numberTimesToIterate > 0) {
			numberTimesToIterate--;
			numberTimesIterated++;
			if (numberTimesIterated >= 21) {
				continue;
			}
			numberIterationsCounted++;
		}
		System.out.println("This loop iterated " + numberTimesIterated
				+ " times, but the value for numberIterationsCounted is only " + numberIterationsCounted);
		
		return;
	}

}
