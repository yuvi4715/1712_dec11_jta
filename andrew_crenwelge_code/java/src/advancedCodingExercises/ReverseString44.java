package advancedCodingExercises;

public class ReverseString44 {

	public static void main(String[] args) {
		/*
		 * Write a method to reverse a String without using API functions.
		 */
		System.out.println(reverseStr("hello, world!"));
	}

	static String reverseStr(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; --i)
			sb.append(s.charAt(i));
		return sb.toString();
	}

}
