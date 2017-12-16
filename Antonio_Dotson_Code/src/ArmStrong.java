//Antonio Dotson --- use scanner import for user input
import java.util.Scanner;
//Problem 43
class Armstrong
{
   public static void main(String args[])
   {
	   //declared several variables.
      int n;
      int sum = 0; 
      int temp; 
      int remainder; 
      int number = 0;
     
      Scanner in = new Scanner(System.in);
      System.out.println("Input a number to check for Armstrong number");
      // get user input
      n = in.nextInt();
 
      temp = n;
 
      // Count number of digits
 
      while (temp != 0) {
         number++;
         temp = temp/10;
      }
 
      temp = n;
      //get the remainder and do additional calculation
      while (temp != 0) {
         remainder = temp%10;
         sum = sum + raise(remainder, number);
         temp = temp/10;
      }
      // print the results
      if (n == sum)
         System.out.println(n + " is an Armstrong number.");
      else
         System.out.println(n + " is not an Armstrong number.");         
   }
 // created method with a return value to do calculation 
   static int raise(int n, int r) {
      int c, p = 1;
 
      for (c = 1; c <= r; c++) 
         p = p*n;
 
      return p;   
   }
}