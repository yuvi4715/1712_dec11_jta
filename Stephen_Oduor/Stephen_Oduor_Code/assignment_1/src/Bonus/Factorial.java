package Bonus;
/**
 * Name: Stephen Oduor
 * Date: 12/15/2017
 * Question: Write a Java application that computes the factorial of a number
 */

public class Factorial {

    public static void main(String[] args){

        int n = 0;
        int factorial = n;


        for(int i = 0; i <= n; i++){

            if(n == 0){
                factorial = 1;
                break;
            }else {

                factorial = n * (i - 1);
            }
        }

       System.out.println(factorial);
    }


}
