package question55;

import java.util.HashSet;

public class FindDuplicateLetters {

		//public int[] numbers = {1,2,3,4,5,4,2,7};
		String letters = "abcdefghijabcdejikmnrraf";
		String written = "";
		public static void main(String[] args) {
			FindDuplicateLetters findDuplicateLetters = new FindDuplicateLetters();
			System.out.print("Duplicates: ");
			System.out.println(findDuplicateLetters.findDuplicates());
		}

		public String findDuplicates() {
			HashSet<Character> duplicates = new HashSet<Character>();
			for(int i = 0; i < letters.length() - 1; i++) {
				for(int j =  i + 1; j < letters.length() - 1; j++) {
					if(letters.charAt(i) == letters.charAt(j)) {
						duplicates.add(letters.charAt(i));
					}
				}
			}
			 duplicates.forEach(number -> written += number.toString() + ", ");
			return written;
			
		}
}
