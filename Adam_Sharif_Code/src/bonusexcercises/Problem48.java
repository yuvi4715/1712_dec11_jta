package bonusexcercises;

public class Problem48 {

	public static void main(String[] args) {
		
		int factorial = 1;
		int number = 7;
		
		for(int i = 1; i < number; i++) {
			factorial = factorial * i;
		}
		System.out.println("The factorial of " + number + " is " + factorial);
	}

}
