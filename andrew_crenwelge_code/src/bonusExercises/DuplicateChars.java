package bonusExercises;

import java.util.Set;
import java.util.TreeSet;

public class DuplicateChars {
	/*
	 * Write a program to find duplicate characters in a String.
	 */

	public static void main(String[] args) {
		String test = "a test string to see if this program works";
		System.out.println(findDuplicates(test));
	}
	
	public static Set<String> findDuplicates(String str) {
		String[] arr = str.split("");
		Set<String> duplicates = new TreeSet<>();
		for (int i=0;i<arr.length;i++) {
			String s = arr[i];
			for (int j=0;j<arr.length;j++) {
				if (s.equals(arr[j]) && i!=j) {
					duplicates.add(s);
				}
			}
		}
		return duplicates;
	}

}
