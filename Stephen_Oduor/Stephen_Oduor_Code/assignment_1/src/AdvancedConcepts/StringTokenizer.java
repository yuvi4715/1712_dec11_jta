package AdvancedConcepts;

/**
 * Name: Stephen Oduor
 * Date: 12/14/2017
 * Question: 17
 * Description: Create a new String with delimited tokens such as word:word:word and use
 *              StringTokenizer to parse out and print each token
 */

public class StringTokenizer {


//"pickles:ketchup:mustard:onion"
    public static void main(String[] args){

        String str = "pickles:ketchup:mustard:onion";
        String s[] = str.split(":");

        for(String string : s){
            System.out.println(string);
        }

    }

}
