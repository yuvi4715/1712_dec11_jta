package part11_AdvancedExercises;

public class FizzBuzz {
	
	public static void main(String[] args) {
		
		for (int i = 1; i <= 50; i++) {
			
			if (i % 5 == 0) {
				if (i % 3 == 0) {
					System.out.println("FizzBuzz");
					continue;
				}
				System.out.println("Buzz");
				continue;
			}
			
			if (i % 3 == 0) {
				if (i % 5 == 0) {
					System.out.println("FizzBuzz");
					continue;
				}
				System.out.println("Fizz");
				continue;
			}
			
			System.out.println(i);
		}
	}
}
