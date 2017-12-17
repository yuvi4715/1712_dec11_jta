package AdvancedCoding;

/**
 * Name: Stephen Oduor
 * Date: 12/13/2017
 * Question: Write a java program to print the fist 100 Fibonacci numbers using iteration. Rewrite using recursion
 */
public class Fibonacci {

    public static void main(String[] args){

        int n = 0;

        //iterationFibonacci();
        recursionFibonacci(100, 0, 1);



    }

    public static int recursionFibonacci(int n, int num1, int num2){

        System.out.println(num1 + num2);

        if(n == 0){
            return num1 + num2;
        }else{
            return recursionFibonacci(n - 1, num2, num1 + num2);
        }

    }

    public static void iterationFibonacci(){

        int sum1 = 0;
        int sum2 = 1;
        int total = 0;

        for(int i = 0; i < 100; i++){

            //System.out.println(sum1 + "\t" + sum2 + "\t" + total);
            total = sum1 + sum2;
            System.out.println(sum1 + " + " + sum2 + " = "+ total);

            sum1 = sum2;
            sum2 = total;
        }

    }

}
