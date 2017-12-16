package getasew.assignment1.advancedcoding;
//45.Write a method to determine if a number is prime. 

public class PrimeNumber {
	public static void main(String[] args) {
		System.out.println(checkNumberPrime(19));
	}


	public static boolean checkNumberPrime(int n) {
		for(int i = 1;i<=9;i++) {
			if((i != 1) && (i != n)) {
				if(n % i == 0) {
					return false;
				}
			}
		}
		return true;


	}
}