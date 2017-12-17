package part10_EasyExercises;

import java.util.Scanner;

// Number 33 - Program checks if the integer passed by the user is an even or odd number.
//					If it is, PASS. If not, FAIL.
public class CheckOddEven {

	public static void main(String[] args) {
		
		System.out.print("Enter A Number: ");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		if((x%2) == 0) {
			System.out.println("Even Number");
		} else {
			System.out.println("Odd Number");
		}
	}
	
}
