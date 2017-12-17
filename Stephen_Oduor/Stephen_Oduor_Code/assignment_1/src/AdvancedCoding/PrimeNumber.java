package AdvancedCoding;

/**
 * Name: Stephen Oduor
 * Date: 12/13/2017
 * Questiom: Write a method to determine if a method is prime
 */

public class PrimeNumber {

    public static void main(String[] args){

        if(isPrime(5)){
            System.out.println("Is prime");
        }else{
            System.out.println("Not prime");
        }
    }

    //Returns true or false if n is a prime number
    public static boolean isPrime(int n){
        //If a number divided has 0 as remainder. It is not prime.
        int num = 5;
        int j = 0;
        boolean isPrime = true;

        //num + 1 to avoid index out of bounds
        for(int i = 2; i < num ; i++){
            //Only check mod of numbers not 1 and num
            if((num % i) == 0 ){
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

}
