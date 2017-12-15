package advancedCodingExercises;

public class ReverseString {
	public static void main(String[] args) {
		reverseString("William");
	}
	
//	public static void reverseString(String original) {
//		String reversed = "";
//		for (int i = original.length() -1; i > -1; i-- ) {
//			reversed += original.toCharArray()[i];
//		}
//		System.out.println(reversed.toString());
//	}
	
	
	
	public static void reverseString(String toBeReversed) {
		StringBuilder builder1 = new StringBuilder(toBeReversed);
		StringBuilder builder2 = new StringBuilder();
		for (int i = builder1.length() -1; i > -1; i--) {
			builder2.append(builder1.charAt(i));
		}
		System.out.println(new String(builder2));
	}
}
