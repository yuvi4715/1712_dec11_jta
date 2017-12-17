package EasyCoding;

import java.util.Scanner;

/**
 * Name: Stephen Oduor
 * Date: 12/12/2017
 * Question: Write a program called KeyBoardScanner to prompt user for an int, a double, and a String.
 *           print result in console.
 */


public class KeyboardScanner {

    public static void main(String[] args){


        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a double: ");
        System.out.println("double: " + scanner.nextDouble());
        System.out.print("Please enter a int: ");
        System.out.println("int: " + scanner.nextInt());
        System.out.print("Please enter a string: ");
        System.out.println("string: " + scanner.nextLine());

    }

}
