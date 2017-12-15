package bonusExercises;

public class DistinctElementsInAnArray {

	
	public static int[] getDistinctElements(Object[] array) {
		int[] histogram = new int[array.length];
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < histogram.length; j++) {
				if (array[i].equals(array[j])) {
					histogram[j]++;
				}
			}
		}
		return histogram;
	}
	
	public static void printDistinctElements(Object[] array) {
		int[] histogram = getDistinctElements(array);
		System.out.println("Distinct elements from input:");
		for (int i = 0; i < histogram.length; i++) {
			if (histogram[i] == 1) {
				System.out.println(array[i]);
			}
		}
	}
	
	public static void main(String[] args) {
//		Object[] testArray = {"hello", "hello", "hi", "sup", "sup", "howdy"};
//		Object[] testArray = {2.0, 2.1, 2.2, 2.0, 13.0};
		Object[] testArray = {'a', 'A', 'b', 'b', 'c', 'C', 'n', '&'};
		printDistinctElements(testArray);
	}
}
