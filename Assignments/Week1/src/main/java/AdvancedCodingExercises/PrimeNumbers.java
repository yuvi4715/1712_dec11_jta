package AdvancedCodingExercises;

public class PrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(check(8));
	}
	
	private static Boolean check(int number) {
		boolean prime = true;
		for (int i = 2; i < number/2; i++) {
			if((number%i) ==0) {
				prime = false;
			}
		}
		return prime;
	}
}
