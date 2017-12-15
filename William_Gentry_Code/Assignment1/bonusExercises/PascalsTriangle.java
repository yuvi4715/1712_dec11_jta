package bonusExercises;

public class PascalsTriangle {

	
	static int recursiveFactorial(int n) {
		int k = 1;
		if (n > 1) {
			k *=( n * recursiveFactorial(n - 1));
		}
		return k;
	}
	
	static int combination(int n, int k) {
		if (n >= k) {
			return ((recursiveFactorial(n)) / ((recursiveFactorial(k)) * (recursiveFactorial(n - k))));
		} else {
			return -1;
		}
	}
	
	
	static void printPascalRow(int upperBound) {
		for (int i = 0; i <= upperBound; i++) {
			System.out.print(combination(upperBound, i) + " ");
			
		}
	}
	
	static void printFirstNRowsOfPascalsTriangle(int n) {
		for (int i = 0; i <= n; i++) {
			printPascalRow(i);
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		printFirstNRowsOfPascalsTriangle(10);
	}
	
	
}
