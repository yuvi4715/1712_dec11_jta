package coreJava;

public class CoreJava2 {
	/*
	 * Write a program to search for the greatest of three numbers using Short-circuit Operators and print the result.
	 */

	public static void main(String[] args) {
		FindGreatest(5,6,4);
	}
	
	public static void FindGreatest(int x,int y,int z) {
		int grt = (x > y && x > z) ? x : (y>z ? y : z);
		System.out.println("The greatest number is " + grt);
	}
}
