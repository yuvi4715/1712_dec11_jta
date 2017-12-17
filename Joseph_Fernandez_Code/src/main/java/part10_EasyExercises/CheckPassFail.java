package part10_EasyExercises;

import java.util.Scanner;

// Number 32 - Program checks if the integer passed by the user is greater than or equal to 50.
//					If it is, PASS. If not, FAIL.
public class CheckPassFail {
	
	public static void main(String[] args) {
		
		System.out.print("Enter A Number: ");
		Scanner sc = new Scanner(System.in);
		int mark = sc.nextInt();
		
		if(mark >= 50) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		
	}
	
}
