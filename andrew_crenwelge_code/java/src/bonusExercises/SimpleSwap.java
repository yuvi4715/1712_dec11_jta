package bonusExercises;

public class SimpleSwap {

	public static void main(String[] args) {
		// Write a method that swaps two integer variables without using a third variable.
		int a = 1, b = 2;
		a = swapTwo(b, b = a);
		System.out.println("a: " + a + ", b: " + b); // prints a: 2, b: 1
	}
	static int swapTwo(int x, int y) {
	    return x;
	}
}
