import java.util.Scanner;
//import scanner to get user input
public class KeyboardScanner {
	   //Problem 35
	public static void main(String[] args) {
		
		  /*
		   * Put user input in three variables and simply printed it back to the console.
		   */
		   Scanner input = new Scanner(System.in);
		   System.out.println("Enter an Integer");
		   // first input 
		   int intputNumber = input.nextInt();
		   System.out.println("Enter a double");
		   // second input
		   double intputDouble = input.nextDouble();
		   System.out.println("Enter your Name");
		   //third input 
		   String intputString = input.next();
		   
		   System.out.println("Your integer is" +" "+ intputNumber + " "+"Double is" + intputDouble+ " Your name is "+ intputString);
		   input.close();
	 }
	}