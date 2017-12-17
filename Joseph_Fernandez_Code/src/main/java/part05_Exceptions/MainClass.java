package part05_Exceptions;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) throws AgeException {
		
		System.out.println("How Old Are You?");
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		
		try {
			System.out.println("Start Try Block");
			
//			System.exit(0);	// -- if before the exception, the finally block will NOT run
			
			if(age <= 0) {
				throw new AgeException("You CANNOT have negative age!");
			}

//			System.exit(0);	// -- if after the exception, the finally block WILL still run
			
			System.out.println("Ending Try Block");
		} catch (AgeException ce) {
			System.out.println();
			System.out.println("Start Catch Block");
			System.out.println(ce.getMessage());
			System.out.println("Ending Catch Block");
		} finally {
			System.out.println();
			System.out.println("Graceful Goodbye!");
		}
	}
}
