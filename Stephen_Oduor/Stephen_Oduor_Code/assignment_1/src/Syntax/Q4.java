package Syntax;

/**
 * Name: Stephen Omondi
 * Date: 12/10/17
 * Question: Write a program to add, subtract, multiply and divide two numbers using methods with parameters using
 *          only one class
 */

public class Q4 {

    public static void main(String[] args){

        System.out.println("Result of add(1,1): " + add(1,1) );
        System.out.println("Result of subtract(1,1): " + subtract(1,1));
        System.out.println("Result of divide(1,1): " + divide(1,1));

    }

    //Adds two numbers
    public static int add(int a, int b){
        return a + b;
    }

    //Subtracts two numbers
    public static int subtract(int a, int b){
        return a - b;
    }

    //Divides two numbers
    public static int divide(int a, int b){
        return a / b;
    }

}
