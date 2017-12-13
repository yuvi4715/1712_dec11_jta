package AdvancedCodingExercises;

import java.math.BigInteger;

public class Fibonacci {
	
	public  int recursive(int n) {
		
		if(n == 1 || n == 0) {
			return n;
		}
		
		return (recursive(n - 1) + recursive(n - 2));
	}
	
	public void iteration(int n) {
		BigInteger a = new BigInteger("1");
		BigInteger b = new BigInteger("1");
		BigInteger c = new BigInteger("1");
		for (int i = 0; i < 3; i++) {
			System.out.printf("Index %d: 1\n",i);
		}
		for (int i = 3; i < n; i++) {
			c = a.add(b);
			a = b;
			b = c;	
			System.out.printf("Index %d: %d\n",i,c);
		}
	}
}
