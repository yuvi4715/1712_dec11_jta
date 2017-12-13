package com.revature.assignment1.easy_coding_exercises;

public class PrintNumberInWord {

	public static void main(String[] args) {

		int number = 5;
		String numberInWord;
		switch (number) {
		case 1:
			numberInWord = "ONE";
			break;
		case 2:
			numberInWord = "TWO";
			break;
		case 3:
			numberInWord = "THREE";
			break;
		case 4:
			numberInWord = "FOUR";
			break;
		case 5:
			numberInWord = "FIVE";
			break;
		case 6:
			numberInWord = "SIX";
			break;
		case 7:
			numberInWord = "SEVEN";
			break;
		case 8:
			numberInWord = "EIGHT";
			break;
		case 9:
			numberInWord = "NINE";
			break;
		default:
			numberInWord = "OTHER";
			break;
		}
		System.out.println(numberInWord);
	}

}
