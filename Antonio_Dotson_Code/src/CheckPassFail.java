import java.util.Scanner;

public class CheckPassFail {

	public static void main(String[] args) {
	 int checkNumber = getMarker();
	 if (checkNumber >= 50 ) {
		 System.out.println("You Passed!");
	 } else {
		 System.out.println("You Failed!");
	 }
	}
   public static int getMarker() {
	   int intputNumber = 0;
	   Scanner input = new Scanner(System.in);
	   System.out.println("Enter Grade to determine if Passed or Failed");
	   try {
	   intputNumber = input.nextInt();
       } catch (Exception e) {
    	 System.out.println("Please enter a number only");  
       }
	   return intputNumber;
 }
}
   
