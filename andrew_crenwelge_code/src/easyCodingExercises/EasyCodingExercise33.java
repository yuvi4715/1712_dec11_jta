package easyCodingExercises;

public class EasyCodingExercise33 {

	public static void main(String[] args) {
		/*
		 * Write a program called CheckOddEven which prints "Odd Number" 
		 * if the int variable “number” is odd, or “Even Number” otherwise. 
		 * Hint: you may use modulus operator.
		 */
		CheckOddEven(5);
	}
	
	private static void CheckOddEven(int num) {
		if (num % 2 != 0)
			System.out.println("Odd number");
		else
			System.out.println("Even number");
	}
}
