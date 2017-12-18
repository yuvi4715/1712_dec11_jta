
public class CommonElements {

	public static void main(String a[]) {
		
		//Finding common elements between two arrays
		int[] array1 = { 4, 8, 12, 16, 20 };
		int[] array2= { 2, 4, 6, 8, 10, 12, 14 };
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (array1[i] == array2[j]) {
					System.out.println(array1[i]);
				}
			}
		}
	}
}