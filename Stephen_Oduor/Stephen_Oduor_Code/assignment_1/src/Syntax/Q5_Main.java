package Syntax;

/**
 * Name: Stephen Omondi
 * Date: 12/10/2017
 * Question: In one project create two classes. One class should contain only methods (add, subtract, multiply and divide)
 *          The other class should contain only the main() method which calls each of the methods from the previous class
 */


public class Q5_Main {

    public static void main(String[] args){

        Q5_Methods methods = new Q5_Methods();

        System.out.println("Result of add(1,1): " + methods.add(1,1) );
        System.out.println("Result of subtract(1,1): " + methods.subtract(1,1));
        System.out.println("Result of divide(1,1): " + methods.divide(1,1));


    }
}
