package assign_1; // this class contains the code for number 45

import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // created a scanner to take input from the user
		
		System.out.println("Enter the number which you wish to check is a prime or not: ");
		isPrime(scan.nextInt()); // statically calls isPrime() method and uses the user input from the scanner as the parameter
		
		scan.close(); // close scanner
	}
	
	static void isPrime(int n) {
		boolean prime = true; // creates a boolean variable called prime and assigns the value true
	    for (int p = 2; p < n; p++) { // for loop to determine whether the entered number is prime or not
	        if (n % p == 0) { // if n mod p equals 0, execute the statements
	            prime = false; // assigns false to the variable prime
	            break; 
	        }
	    }
	    if (prime) // if a number is prime, print that
	        System.out.println(n + " is a prime number.");
	    else // else, print this
	        System.out.println(n + " is not a prime number.");
	    
	}

}
