package bonusExercises;

public class Factorial {

	static void iterativeFactorial(int n) {
		int factorialValue = 1;
		if (n < 0) {
			System.out.println("Input must be greater than zero");
		} 
		if (n > 1) {
			for (int i = n; i > 0; i--) {
				factorialValue *= i;
			}
		}
		System.out.println(n + "! = " + factorialValue);
	}
	
	static int recursiveFactorial(int n) {
		int k = 1;
		if (n > 1) {
			k *=( n * recursiveFactorial(n - 1));
		}
		return k;
	}
	
	public static void main(String[] args) {
		System.out.println(recursiveFactorial(10));
	}
}

