package bonusExercises;

public class Factorial {

	public static void main(String[] args) {
		/*
		 * Write a Java application that computes the factorial of a number.
		 */
		System.out.println(factorial(6));
	}
	
	public static int factorial(int a) {
		if (a <= 1) {
			return 1;
		}
		else {
			return a * factorial(a-1);
		}
	}

}
