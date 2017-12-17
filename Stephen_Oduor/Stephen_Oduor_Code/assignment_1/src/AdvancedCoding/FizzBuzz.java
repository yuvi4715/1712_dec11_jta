package AdvancedCoding;

/**
 * Name: Stephen Oduor
 * Date: 12/13/2017
 * Question: Write a Java program that prints the numbers from 1 to 50. But for multiples of three print
 *           "Fizz" instead of the number and for the multiple of five print "Buzz". For the numbers which are
 *            multiples of both three and five print "FizzBuzz"""
 */


public class FizzBuzz {

    public static void main(String[] args){

        for(int i = 1; i < 51; i++){

            if((i % 3) == 0 && (i % 5) == 0){
                System.out.println("FizzBuzz");
            }
            else if((i % 3) == 0){
                System.out.println("Fizz");

            }else if((i % 3) == 5){
                System.out.println("Buzz");
            }
            else{
                System.out.println(i);
            }
        }
    }


}
