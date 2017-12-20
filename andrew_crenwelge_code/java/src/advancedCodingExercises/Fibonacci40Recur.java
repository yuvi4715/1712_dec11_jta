package advancedCodingExercises;

public class Fibonacci40Recur {
	public static void main(String[] args) {
		// Write a Java program to print the first 100 Fibonacci numbers using iteration. 
		// Rewrite using recursion.
		getFibSeq(100);
	}
	
	public static int getFib(int nthFib) {
		if (nthFib <= 1) {
			return nthFib;
		}
		else {
			return getFib(nthFib-1) + getFib(nthFib-2);
		}
	}
	
	public static void getFibSeq(int nthFib) {
		for (int a=1;a<=nthFib;a++) {
			System.out.println(a+" | "+getFib(a));
		}
	}
}
