package Core_Java;

/**
 * Name: Stephen Omondi
 * Date: 12/10/2017
 * Description: A program to search for the greatest of three numbers
 *              using short-circuit operators and prints the result
 */

public class Q2 {



    public static void main(String[] args){
        int a = 7, b = 7, c = 7;

        if((a > b) && (a > c)){
            System.out.println("a(" + a + ") is the greatest number");
        }else if(b > a && b > c){
            System.out.println("b(" + b + ") is the greatest number");
        }else if(c > a && c > b){
            System.out.println("c(" + c + ") is the greatest number");
        }else{
            System.out.println("All numbers are equal");
        }
    }


}
