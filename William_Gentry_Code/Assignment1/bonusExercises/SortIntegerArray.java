package bonusExercises;

public class SortIntegerArray {
	
	
	static void sortInAscendingOrder(int[] array) {
		System.out.print("Original array: [");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.println(array[i] + "]");
			} else {
				System.out.print(array[i] + ", ");
			}
		}
		System.out.println("Sorting...");
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < (array.length - i); j++) {
				if (array[j-1] > array[j]) {
					array[j-1] = array[j-1] ^ array[j];
					array[j] = array[j] ^ array[j-1];
					array[j-1] = array[j-1] ^ array[j];
				}
			}
		}
		
		System.out.print("Sorted array (ascending): [");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.println(array[i] + "]");
			} else {
				System.out.print(array[i] + ", ");
			}
		}
		
	}
	
	static void sortInDescendingOrder(int[] array) {
		System.out.print("Original array: [");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.println(array[i] + "]");
			} else {
				System.out.print(array[i] + ", ");
			}
		}
		System.out.println("Sorting...");
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < (array.length - i); j++) {
				if (array[j-1] < array[j]) {
					array[j-1] = array[j-1] ^ array[j];
					array[j] = array[j] ^ array[j-1];
					array[j-1] = array[j-1] ^ array[j];
				}
			}
		}
		
		System.out.print("Sorted array (ascending): [");
		for (int i = 0; i < array.length; i++) {
			if (i == array.length - 1) {
				System.out.println(array[i] + "]");
			} else {
				System.out.print(array[i] + ", ");
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		sortInAscendingOrder(new int[] {4, 8, 1, 3, 2, 7, 5, 9, 6});
		System.out.println();
		sortInDescendingOrder(new int[] {4, 8, 1, 3, 2, 7, 5, 9, 6});
	}
	
	
	
}
