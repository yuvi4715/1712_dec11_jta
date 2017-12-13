package AdvancedCodingExercises;

public class FibMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fibonacci fib = new Fibonacci();
		int fibo = 100;
		fib.iteration(fibo + 1);
		System.out.printf("\nAt Index %d: %d", fibo, fib.recursive(fibo));

	}

}
