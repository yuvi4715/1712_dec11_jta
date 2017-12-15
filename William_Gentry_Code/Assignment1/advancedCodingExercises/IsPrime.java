package advancedCodingExercises;

public class IsPrime {

	private int n;
	
	public IsPrime(int num) {
		this.n = num;
		if (this.testForPrime()) {
			System.out.println(num + " is a prime number");
		} else {
			System.out.println(num + " is not a prime number");
		}
	}
	
	public boolean testForPrime() {
		boolean isPrime;
		int numDivisors = 0;
		if (this.n < 1) {
			isPrime = false;
		}
		for (int i = 1; i < this.n+1; i++) {
			if (this.n % i == 0) {
				numDivisors++;
			}
		}
		if (numDivisors == 2) {
			isPrime = true;
		} else {
			isPrime = false;
		}
		return isPrime;
	}
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 1001; i++) {
			new IsPrime(i);
		}
	}
}
