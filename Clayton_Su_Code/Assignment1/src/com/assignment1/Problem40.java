package com.assignment1;

public class Problem40 {

	public static long fiboIter(int n) {
		long y = 0, x = 1, aux;

		for (int i = 0; i < n; i++) {
			aux = y;
			y = x;
			x = x + aux;
		}
		return y;

	}

	static int fibRecur(int x) {
		return x > 1 ? fibRecur(x - 1) + fibRecur(x - 2) : x;
	}

	public static void main(String[] args) {
		System.out.println(fiboIter(20));
		System.out.println(fibRecur(20));
	}

}
