package com.revature.as1.easy;

public class CheckPassFail {

	public static void main(String[] args) {
		int mark = 50;
		checkPassFail(mark);
		checkOddEven(mark);
		printNumberInWord(mark);
	}

	public static void checkPassFail(int mark) {
		if (mark >= 50) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}

	public static void checkOddEven(int mark) {
		if (mark % 2 == 0) {
			System.out.println("Mark is even.");
		} else {
			System.out.println("Mark is odd.");
		}
	}

	public static void printNumberInWord(int mark) {
		String out = "";

		switch (mark) {
		case 0:
			out = "ZERO";
			break;
		case 1:
			out = "ONE";
			break;
		case 2:
			out = "TWO";
			break;
		case 3:
			out = "THREE";
			break;
		case 4:
			out = "FOUR";
			break;
		case 5:
			out = "FIVE";
			break;
		case 6:
			out = "SIX";
			break;
		case 7:
			out = "SEVEN";
			break;
		case 8:
			out = "EIGHT";
			break;
		case 9:
			out = "NINE";
			break;
		default:
			out = "OTHER";
			break;

		}
		System.out.println(out);
	}
}
