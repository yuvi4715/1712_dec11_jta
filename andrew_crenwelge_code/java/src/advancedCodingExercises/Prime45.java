package advancedCodingExercises;

public class Prime45 {

	public static void main(String[] args) {
		/*
		 * Write a method to determine if a number is prime. 
		 */
		
		// determine whether each number 1-20 is prime
		for (int n=1;n<=20;n++) {
			System.out.println(n+": "+isPrime(n));
		}
	}
	
	public static boolean isPrime(int n) {
		int a = n-1;
		while(a>1) {
			if (n % a == 0) return false;
			a--;
		}
		return true;
	}

}
