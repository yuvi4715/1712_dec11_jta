package EasyCoding;

/**
 * Name: Stephen Oduor
 * Date: 12/13/2017
 * Question: Write a program called Arithmetic that takes three command line arguments: two integers followed
 *           by an arithmetic operator (+,-,*,/). The program shall perform the corresponding operation on the two
 *           integers and print the result.
 */

public class Arithmetic {

    public static void main(String[] args){

        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        String operator = args[2];

        switch(operator){
                case "+":
                System.out.println("The result of " + num1 + operator + num2 + " is: " + (num1 + num2));
                break;

                case "-":
                System.out.println("The result of " + num1 + operator + num2 + " is: " + (num1 - num2));
                break;

                case "*":
                System.out.println("The result of " + num1 + operator + num2 + " is: " + (num1 * num2));
                break;

                case "/":
                System.out.println("The result of " + num1 + operator + num2 + " is: " + (num1 / num2));
                break;
        }

    }


}
