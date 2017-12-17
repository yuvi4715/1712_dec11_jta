package AdvancedConcepts;
import java.lang.*;

/**
 * Name: Stephen Oduor
 * Date: 12/14/2017
 * Question: 16
 * Description: Create a StringBuilder object. Use at least three methods to manipulate the String
 */

public class StringBuilderMethods {


    public static void main(String[] args){
        StringBuilder str = new StringBuilder("brown");
        System.out.println(str.append("fox"));
        System.out.println(str.delete(0,5));
        System.out.println(str.reverse());

    }


}
