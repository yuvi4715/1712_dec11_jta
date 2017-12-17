package AdvancedCoding;

/**
 * Name: Stephen Oduor
 * Date: 12/13/2017
 * Question: Write a method to replace a given character in a String with another character.
 */

public class ReplaceCharacter {

    public static void main(String[] args){

        String str = "stephen";
        System.out.println(replace(str, 's','r'));

    }

    public static String replace(String str, char oldCh, char newCh){

        return str.replace(oldCh, newCh);
    }

}
