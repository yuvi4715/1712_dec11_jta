package Bonus;

import java.util.ArrayList;

public class Dupes {
	private static final ArrayList<Integer> numberCheck = new ArrayList<>();
	private static final int[] intArray =  new int[] {1,2,3,4,5,6,7,8,9,10,2,32,4};

	public static void main(String[] args) {
		checkDupes();

	}

	private static void checkDupes() {

		for (int i : intArray) {
			if (numberCheck.contains(i)) {
				System.out.println("Found dupe: " + i);
			} else {
				numberCheck.add(i);
			}
		}

	}
}
