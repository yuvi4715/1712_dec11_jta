package question45;

import java.util.Scanner;

public class FindPrime {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a natural number to find out if it is prime");
		int a = scanner.nextInt();

		for(int i = 2; i < a; i++) {
			if(a % i == 0) {
				System.out.println("The number is not prime.");
				return;
			}
		}
		System.out.println("The number is prime!");
	}

}
