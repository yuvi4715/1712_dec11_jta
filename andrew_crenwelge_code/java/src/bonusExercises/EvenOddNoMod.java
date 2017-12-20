package bonusExercises;

public class EvenOddNoMod {
	/*
	 * Write a method that determines if a number is even or odd without using modulus
	 */

	public static void main(String[] args) {
		int n = 138550;
		if (n != (n/2)*2)
			System.out.println("It's odd!");
		else
			System.out.println("It's even!");
	}
}
