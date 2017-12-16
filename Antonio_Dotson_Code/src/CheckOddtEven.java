import java.util.Scanner;
//Problem 33
public class CheckOddtEven {
// use scanner to get user input
	public static void main(String[] args) {
		 int checkNumber = getUserInput();
		 /*
		  * Check to verify if the number is a division of 2 which would mean even
		  */
		 if (checkNumber % 2 == 0) {
			  // even
			 System.out.println("The number is even"+" "+checkNumber);
			} else {
			  // odd
				 System.out.println("The number is odd"+" "+checkNumber);
			}
		}
	/*
	 * getUserInput gets a numeric value from the user and then checks for errors
	 * incorrect user input if its a non number, if its a number then the method
	 * returns the number.
	 */
	   public static int getUserInput() {
		   int intputNumber = 0;
		   Scanner input = new Scanner(System.in);
		   System.out.println("Enter Any number to determine odd or even");
		   try {
		   intputNumber = input.nextInt();
	       } catch (Exception e) {
	    	 System.out.println("Please enter a number only");  
	       }
		   input.close();
		   return intputNumber;
	 }
	}
	   
  