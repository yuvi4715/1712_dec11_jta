package assign_1;   // this class contains the code for number 40

public class FibonacciNumbers {

	public static void main(String args[]) {

		int num = 100; // created an int called num and assigned it 100;

		System.out.println("Here are the first 100 Fibonacci numbers:");

		for (int n = 1; n <= num; n++) { // for loop to print every Fibonacci number
			System.out.print(fibonacci2(n) + " ");
		
			System.out.println(fibonacciRecursive(n)); // statically calling fibonacciRecursive to run
	}
}

	public static long fibonacciRecursive(int num) { // recursive fibonacci method taking one integer as a parameter
		if (num == 1 || num == 0) { // if num ==1 OR num == 0, return num
			return num;
		}
		return fibonacciRecursive(num - 1) + fibonacciRecursive(num - 2); // recursive call of the method itself
	}

	public static long fibonacci2(int number) { // iterative fibonacci method
		if (number == 1 || number == 2) { // if number == 1 OR number == 2, return 1
			return 1;
		}

		int fibo1 = 1, fibo2 = 1, fibonacci = 1; // creating 3 integers and assigning them all 1;
		for (int n = 3; n <= number; n++) { // for loop to iterate through fibonacci numbers and print them

			fibonacci = fibo1 + fibo2; // assigning fibonacci the value of the sum of fibo1 and fibo 2
			fibo1 = fibo2; // assigning the value of fibo2 to fibo1
			fibo2 = fibonacci; // assigning the value of fibonacci to fibo2
		}

		return fibonacci; // return fibonacci number
	}
}
