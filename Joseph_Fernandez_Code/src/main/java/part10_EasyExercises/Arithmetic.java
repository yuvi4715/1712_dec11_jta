package part10_EasyExercises;

import java.util.Scanner;

// Number 36 - Program takes three user inputs: two integers and an arithmetic operator.
//				The program will perform the operation with the two integers.
public class Arithmetic {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Integer One: ");
		int num1 = sc.nextInt();
		System.out.print("Enter Integer Two: ");
		int num2 = sc.nextInt();
		
		Scanner sc1 = new Scanner(System.in);
		System.out.print("Enter an Arithmetic Operator: ");
		String ao = sc1.nextLine();
		
		int result = 0;
		
		switch (ao.charAt(0)) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = num1 / num2;
				break;
			case '%':
				result = num1 % num2;
				break;
		}
		
		System.out.println();
		System.out.println("Result is: " + result);
		
	}

}
