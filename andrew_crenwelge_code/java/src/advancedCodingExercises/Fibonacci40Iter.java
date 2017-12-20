package advancedCodingExercises;

public class Fibonacci40Iter {
	/*
	 * Write a Java program to print the first 100 Fibonacci numbers using iteration. Rewrite using recursion
	 */

	public static void main(String[] args) {
		// Using a double because int and long would not hold all digits up to 100th Fib #
		double fst = 1;
		double snd = 1;
		System.out.println("1 | "+fst);
		System.out.println("2 | "+snd);
		for (double a=0;a<49;a++) {
			fst = fst + snd;
			System.out.println((2*a+3)+" | "+fst);
			snd = fst + snd;
			System.out.println((2*a+4)+" | "+snd);
		}
	}
}
