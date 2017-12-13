package AdvancedCodingExercises;

public class FizzBuzz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		letsGO();

	}

	private static void letsGO() {
		for (int i = 1; i < 50; i++) {
			
			if((i % 3) == 0 && (i%5) != 0) {
				System.out.printf("Number %d is Fizz\n", i);
			}
			if((i % 3) != 0 && (i%5) == 0) {
				System.out.printf("Number %d is Buzz\n", i);
			}
			if((i % 3) == 0 && (i%5) == 0) {
				System.out.printf("Number %d is FizzBuzz\n", i);
			}
		}
	}
}
