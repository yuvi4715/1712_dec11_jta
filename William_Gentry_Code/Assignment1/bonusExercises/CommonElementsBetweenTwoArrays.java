package bonusExercises;

import java.util.*;

public class CommonElementsBetweenTwoArrays {

	static void commonElements(Object[] array1, Object[] array2) {
		int larger = 0;
		int smaller = 0;
		Object[] largerArray;
		Object[] smallerArray;
		List<Object> commonElements = new ArrayList<Object>();
		if (array1.length > array2.length) {
			larger = array1.length;
			largerArray = copyArray(array1);
			smaller = array2.length;
			smallerArray = copyArray(array2);
		} else if (array1.length < array2.length) {
			larger = array2.length;
			largerArray = copyArray(array2);
			smaller = array1.length;
			smallerArray = copyArray(array1);
		} else {
			larger = array1.length;
			largerArray = copyArray(array1);
			smaller = array2.length;
			smallerArray = copyArray(array2);
		}
		
		for (int i = 0; i < smaller; i++) {
			for (int j = 0; j < larger; j++) {
				if (smallerArray[i]==(largerArray[j])) {
					commonElements.add(largerArray[j]);
				}
			}
		}
		
		
		System.out.print("Common elements between the arrays are");
		for (int i = 0; i < commonElements.size(); i++) {
			if (i == commonElements.size() - 1) {
				System.out.println(" "+commonElements.get(commonElements.size()-1).toString());
			} else {
				System.out.print(" " + commonElements.get(i).toString() + ",");
			}
		}
		
	}

	// helper method to assign arrays based on size for loop
	static Object[] copyArray(Object[] array) {
		Object[] copied = new Object[array.length];

		for (int i = 0; i < array.length; i++) {
			copied[i] = array[i];
		}

		return copied;
	}

	public static void main(String[] args) {
		commonElements(new Object[] { 1, 2, 3, 4, 6, 10, 13 }, new Object[] { 2, 3, 4, 5,
				6, 13, 10 });
	}
}
