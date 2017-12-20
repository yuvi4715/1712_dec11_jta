package bonusExercises;

public class IntArrBubbleSort {
	/*
	 * Write a method that sorts an integer array from least to greatest without using API functions
	 */

	public static void main(String[] args) {
		int[] arr = new int[] {5,9,10,4,7,156,0};
		int[] sorted = bubbleSort(arr);
		for (int a : sorted) {
			System.out.println(a);
		}
	}
	
	public static int[] bubbleSort(int[] arr) {
		boolean swapped;
		do {
			swapped = false;
			for (int i=0;i<arr.length;i++) {
				int temp = arr[i];
				if ((i<arr.length-1) && arr[i] > arr[i+1]) {
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					swapped = true;
				}
			}
		} while (swapped);
		return arr;
	}

}
