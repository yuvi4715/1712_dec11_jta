package assign_1; // this class contains the code for number 43

import java.util.Scanner; 

public class ArmstrongNumber {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); // created a scanner to take input from the user
		
		int c = 0; // created an integer called c and assigned a value of 0;
		int a;
		int temp;
		
		System.out.println("Enter the number that you would like to check whether it is an Armstrong number or not: ");
		int n = scan.nextInt();// It is the number to check Armstrong // take the user input and assign it to n
		
		scan.close(); // close the scanner
		
		temp = n; // assign the value of n to temp
		while (n > 0) { // while n is larger than 0, execute the inner statements
			a = n % 10; // assign the value of n mod 10 to the variable a
			n = n / 10; // assign the value of n divided by 10 to the variable n
			c = c + (a * a * a); // assign the value of a times a times a plus c, to the variable c
		}
		
		if (temp == c) // if temp (which  is now the user input) is equal to c
			System.out.println( temp + " is an Armstrong number"); // print this
		else
			System.out.println(temp + " is not an Armstrong number"); // else print this
	}

}
