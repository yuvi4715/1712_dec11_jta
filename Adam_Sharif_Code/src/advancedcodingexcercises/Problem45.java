package advancedcodingexcercises;

import java.util.Scanner;

public class Problem45 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number");
		int number = input.nextInt();
		if(PrimeNumCheck(number)) {
			System.out.println("The number " + number +" is a prime number" );
		}
		else
			System.out.println("The number " + number +" is not a prime number");
		

	}
	public static boolean PrimeNumCheck(int number) {
		if(number % 2 !=  0) {
			return true;
		}
		else 
			return false; 
	}

}
