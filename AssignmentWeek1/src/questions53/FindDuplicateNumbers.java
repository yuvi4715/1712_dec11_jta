package questions53;

import java.util.HashSet;


public class FindDuplicateNumbers {

	public int[] numbers = {1,2,3,4,5,4,2,7};
	String written = "";
	public static void main(String[] args) {
		FindDuplicateNumbers findDuplicateNumbers = new FindDuplicateNumbers();
		System.out.print("Duplicates: ");
		System.out.println(findDuplicateNumbers.findDuplicates());
	}

	public String findDuplicates() {
		HashSet<Integer> duplicates = new HashSet<Integer>();
		for(int i = 0; i < numbers.length - 1; i++) {
			for(int j = i + 1; j < numbers.length - 1; j++) {
				if(numbers[i] == numbers[j]) {
					duplicates.add(numbers[i]);
				}
			}
		}
		 duplicates.forEach(number -> written += number.toString() + ", ");
		return written;
		
	}
}
