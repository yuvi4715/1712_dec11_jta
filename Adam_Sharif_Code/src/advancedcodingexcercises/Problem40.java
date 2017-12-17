package advancedcodingexcercises;

public class Problem40 {
	public static void main(String args[]) {
		int number = 100;
		System.out.println("Enter number the number of Fibonacci series to print: ");
		System.out.println("Fibonacci series up to " + number + " numbers : ");

		for (int i = 1; i <= number; i++) {
			System.out.print(fibonacci2(i) + " ");
		}
	}

	public static int fibonacci(int num) {
		if (num == 1 || num == 2) {
			return 1;
		}
		return fibonacci(num - 1) + fibonacci(num - 2); 
	}

	public static int fibonacci2(int num) {
		if (num == 1 || num == 2) {
			return 1;
		}
		int fiboprev2 = 1;
		int fiboprev1 = 1; 
		int fibonacci = 1;
		for (int i = 3; i <= num; i++) {
			fibonacci = fiboprev1 + fiboprev2;
			fiboprev1 = fiboprev2;
			fiboprev2 = fibonacci;
		}
		return fibonacci;
	}
}
