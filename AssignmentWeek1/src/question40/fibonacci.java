package question40;

import java.math.BigInteger;

public class fibonacci {

	public static void main(String[] args) {
		fibonacci.iterativeFibonacci();
		fibonacci.recursiveFibonacci();
	}

	public static void iterativeFibonacci() {
		BigInteger a = new BigInteger("0"), 
				b = new BigInteger("1"), 
				c = new BigInteger("1");
		
		System.out.println("Fibonacci sequence iteratively:");
		
		System.out.printf("%d, %d, %d, ", a, b, c);
		
		for(int i = 4; i <= 100; i++) {
			a = b;
			b = c;
			c = a.add(b);
			System.out.print(c + ", ");
		}
		System.out.println();
	}
	
	public static void recursiveFibonacci() {
		BigInteger a = new BigInteger("0"), 
				b = new BigInteger("1"); 
				//c = new BigInteger("1");
		int recursiveTimes = 4;
		System.out.println("Fibonacci sequence recursively:");
		
		System.out.printf("%d, %d, ", a, b);
		recursiveFibonacci2(a, b, recursiveTimes);
	}
	public static void recursiveFibonacci2
	(BigInteger a, BigInteger b, int recursiveTimes) {
		BigInteger c = a.add(b);
		System.out.print(c + ", ");
		if(recursiveTimes <= 100) {
			recursiveFibonacci2(b, c, ++recursiveTimes);
		}
	}
}
