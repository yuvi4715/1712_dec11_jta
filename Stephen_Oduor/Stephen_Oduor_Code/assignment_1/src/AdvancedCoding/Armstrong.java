package AdvancedCoding;

/**
 * Name: Stephen Oduor
 * Date: 12/13/2017
 * Question: Write a Java program to determine if a number is Armstrong i.e a number whose sum is
 *            the sum of its digits cubed
 */

public class Armstrong {

    public static void main(String[] args){

        System.out.println(isArmstrong(371));

    }

    public static boolean isArmstrong(int number){

        int divisor = 10;
        int quotient = 0;
        int remainder = 0;
        int dividend = number;
        int sum = 0,  cubedResult = 0;

        while((dividend % divisor) != 0) {

            remainder = dividend % divisor;

            cubedResult = (int) Math.pow((remainder), 3);
            sum += cubedResult;

            quotient = dividend / divisor;
            dividend = quotient;
        }


        if(sum == number){
            return  true;
        }else {
            return false;
        }
    }

}
