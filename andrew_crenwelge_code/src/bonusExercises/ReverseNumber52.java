package bonusExercises;

public class ReverseNumber52 {
	public static void main(String[] args) {
		/*
		 * Write a program to reverse a number.
		 */
		System.out.println(reverseMe(12345));
	}

	public static int reverseMe(int x) {
		String[] arr = Integer.toString(x).split("");
		String output = "";
		int a=arr.length-1;
		while (a >= 0) {
			output += arr[a];
			a--;
		}
		return Integer.parseInt(output);
	}
}
