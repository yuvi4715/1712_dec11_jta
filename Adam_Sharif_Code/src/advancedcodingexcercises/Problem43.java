package advancedcodingexcercises;

import java.util.Scanner;

public class Problem43 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = input.nextInt();

		if (ArmStrongCheck(num)) {
			System.out.println("The number " + num + " is an Armstrong number");
		} else {
			System.out.println("The number " + num + " is not an Armstrong number");
		}

	}

	private static boolean ArmStrongCheck(int number) {
		int result = 0;
		int orig = number;
		while (number != 0) {
			int remainder = number % 10;
			result = result + remainder * remainder * remainder;
			number = number / 10;
		}
		if (orig == result) {
			return true;
		} else
			return false;

	}
}
