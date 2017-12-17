package AdvancedCoding;

/**
 * Name: Stephen Oduor
 * Date: 12/14/2017
 * Question: 44
 * Description: Write a method to reverse a String without using API functions.
 */

public class ReverseString {

    public static void main(String[] args){

        System.out.println(reverseString("stephen"));
    }

    public static String reverseString(String string){

        String reverseStr = "";

        for(int i = string.length() - 1; i >= 0; i--){
            reverseStr += string.charAt(i);
        }


        return reverseStr;
    }

}
