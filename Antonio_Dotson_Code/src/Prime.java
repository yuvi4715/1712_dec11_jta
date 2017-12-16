import java.util.Scanner;
// Antonio Dotson
public class Prime {
// Problem 45
	public static void main(String[] args) {
		Scanner inputDevice = new Scanner(System.in);
	    System.out.println("Enter number to determine if its a prime number.");
	    // user input
	    int n = inputDevice.nextInt();
	    // close input
	    inputDevice.close();
	    boolean pNum = false;
	    /* loop through number that was inputed, check if its a multiple of 2 and check half of the number,
	    no number is divided by more than half of itself
	    */
	    for(int i= 2; i<=n/2; i++) {
	    // check if the number is prime 
	    if (n % i == 0) {
	    	pNum = true;
	    	break;
	      }
	    }
	if(!pNum) {
		//print out prime or not a prime number
		System.out.println(n + " is a prime number.");
	} else {
		System.out.println(n + " is not a prime number.");
	 }
	}
}	
