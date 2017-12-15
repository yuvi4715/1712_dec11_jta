package advancedCodingExercises;

import java.math.BigInteger;

public class Fibonocci {
	BigInteger fib1 = BigInteger.ZERO;
	BigInteger fib2 = BigInteger.ONE;
	BigInteger fib3;
	
	public void iterationFibonocci() {
		
		for (int i = 0; i < 100; ++i) {
			if (i == 0) {
				System.out.println("Index: " + (i + 1) + "\tFib Value: "+ (fib1));
			}
			if (i == 1) {
				System.out.println("Index: " + (i + 1) + "\tFib Value: " + fib2);
			}
			if (i > 1) {
				fib3 = fib1.add(fib2);
				fib1 = fib2;
				fib2 = fib3;
				System.out.println("Index: " + (i + 1) + "\tFib Value: " + fib3);
			}
		}
	}
	
	//Helper method for recursionFib
	public BigInteger getFib(int n) {
		if (n == 1) {
			return BigInteger.ONE;
		} 
		if (n == 2) {
			return BigInteger.ONE;
		}
		return getFib(n-1).add(getFib(n-2));
	}
	
	public void recursiveFib(int index) {
		for (int i = 1; i < index; i++) {
			System.out.println(getFib(i));
		}
	}
	

	
	public static void main(String[] args) {
		Fibonocci test = new Fibonocci();
		test.recursiveFib(100);
	}
}
