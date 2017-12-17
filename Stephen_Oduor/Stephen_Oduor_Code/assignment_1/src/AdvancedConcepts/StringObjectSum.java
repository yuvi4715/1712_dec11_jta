package AdvancedConcepts;

/***
 * Name: Stephen Oduor
 * Date: 12/14/17
 * Question: 18, 19
 * Description: Create two String objects with number values(i.e 20). Write a method that adds the two
 *              Request garbage collection in your method.
 */

public class StringObjectSum {

    public static void main(String[] args){
        String num1 = "20";
        String num2 = "20";
        int sum = Integer.parseInt(num1) + Integer.parseInt(num2);
        System.out.println(sum);
        System.gc();
    }





}
