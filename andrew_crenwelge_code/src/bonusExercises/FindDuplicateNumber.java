package bonusExercises;

public class FindDuplicateNumber {
	/*
	 * Find a duplicate number from an array of 1 to N numbers
	 */

	public static void main(String[] args) {
		int[] test = new int[] {1,2,3,4,5,3};
		boolean bool = hasDuplicates(test);
		if (bool)
			System.out.println("The duplicate is: "+findDuplicates(test));
		else
			System.out.println("NO DUPLICATES");
	}
	
	public static boolean hasDuplicates(int[] n) {
		boolean duplExists = false;
		for (int a=0;a<n.length;a++) {
			int temp = n[a];
			for (int b=0;b<n.length;b++) {
				if (temp == n[b] && a != b) {
					duplExists = true;
				}
			}
		}
		return duplExists;
	}
	
	public static int findDuplicates(int[] n) {
		for (int a=0;a<n.length;a++) {
			int temp = n[a];
			for (int b=0;b<n.length;b++) {
				if (temp == n[b] && a != b) {
					return temp;
				}
			}
		}
		return 0;
	}
}
