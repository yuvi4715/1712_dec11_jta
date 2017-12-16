// Antonio Dotson --- import Scanner to get user input
import java.util.Scanner;
// Problem 36
public class Arithmetic {

	public static void main(String[] args) {
		// use problem4 class for math methods
		 Scanner input = new Scanner(System.in);
		   Problem4 doOperation = new Problem4();
		   System.out.println("The program requires you to enter a number then the */-+ sign to perform the operation and then another number");
		   System.out.println("\n");
		   System.out.println("Enter first Number");
		   // get the value of user input
		   int intputNumber = input.nextInt();
		   System.out.println("Enter arithmetic operation */+- ");
		   String intputChar = input.next();
		   char aChar = intputChar.charAt(0);
		   System.out.println("Enter last number");
		   int intputDouble = input.nextInt();
		   // changed the +*/- to char for the input, to perform the operations.
		   char acharValue = 42;
		   // multiply
		   char acharValue2 = 43;
		   // add
		   char acharValue3 = 45;
		   //subtract
		   char acharValue4 = 47;
		   //divide	   
		   if (aChar == acharValue) {
			  System.out.println("You want to Multiply");
			  // put variables in methods to perform the operation and print to the screen
			 int ne = doOperation.multNumber(intputNumber, intputDouble);
			 System.out.println("The answer is " + ne);
		   } else if (aChar == acharValue2) {
			   System.out.println("You want to Add");	
			 int np = doOperation.addNumber(intputNumber, intputDouble);
			 System.out.println("The answer is " + np);
		   } else if (aChar == acharValue3) {
		     System.out.println("You want to Subtract");	
			 int nq = doOperation.subNumber(intputNumber, intputDouble);
			 System.out.println("The answer is " + nq);
	      } else if (aChar == acharValue4)  {
	    	  System.out.println("You want to Divide");	
	    	  double nr = doOperation.divNumber(intputNumber, intputDouble);
	    	  System.out.println("The answer is " + nr);
	      } else {
	    	  System.out.println("You have to chose + - / * as order of operation");
	      }
	     
	    }
	}


