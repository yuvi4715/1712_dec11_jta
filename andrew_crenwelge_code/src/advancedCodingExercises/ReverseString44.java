package advancedCodingExercises;

public class ReverseString44 {

	public static void main(String[] args) {
		/*
		 * Write a method to reverse a String without using API functions.
		 */
		System.out.println(reverseStr("hello, world!"));
	}
	
	public static String reverseStr(String str) {
		String[] forward = str.split("");
		String[] backward = new String[forward.length];
		for (int a=0;a<forward.length;a++) {
			backward[forward.length-a-1] = forward[a];
		}
		return String.join("", backward);
	}

}
