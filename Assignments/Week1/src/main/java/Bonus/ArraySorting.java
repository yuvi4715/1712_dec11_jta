package Bonus;

import java.util.*;

public class ArraySorting {

	public static void main(String[] args) {
		int[] test = new int[] { 10, 3, 5, 7, 9, 4 };

		for (int i = 0; i < test.length; i++) {
			sorting(test);
		}
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
	}

	private static int[] sorting(int[] input) {
		int temp;

		for (int i = 0; i < input.length - 1; i++) {
			if (input[i] > input[i + 1]) {
				temp = input[i];
				input[i] = input[i + 1];
				input[i + 1] = temp;
			}
		}

		return input;

	}

}
