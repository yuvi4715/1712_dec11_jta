package advancedCodingExercises;

public class Fibonacci40Iter {

	public static void main(String[] args) {
		// Write a Java program to print the first 100 Fibonacci numbers using iteration. 
		// Rewrite using recursion.
		
		// Using a double because int and long would not hold all digits up to 100th Fib #
		double fst = 1;
		double snd = 1;
		System.out.println(fst);
		System.out.println(snd);
		for (double a=0;a<49;a++) {
			fst = fst + snd;
			System.out.println(fst);
			snd = fst + snd;
			System.out.println(snd);
		}
	}
}
