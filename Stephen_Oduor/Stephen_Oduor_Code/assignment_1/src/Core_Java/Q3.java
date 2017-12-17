package Core_Java;

/**
 * Name: Stephen Omondi
 * Date: 12/10/2017
 * Question 3: Write a program - declate two variables a & b and initialize them to true and false respectively.
 * Get the output of the following computations:
 * !a
 * a | b
 * (!a & b) | (a & !b)
 */


public class Q3 {

    public static void main(String[] args){
        boolean a = true, b = false;
        System.out.println("The result of !a: " + !a);
        System.out.println("The result of a | b: " +  (a | b));
        System.out.println("The result of (!a & b) | (a & !b): " + ((!a & b)| (a & !b)));
    }

}
