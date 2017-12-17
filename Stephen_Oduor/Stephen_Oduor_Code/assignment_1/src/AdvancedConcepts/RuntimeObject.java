package AdvancedConcepts;

/**
 * Name: Stephen Oduor
 * Date: 12/15/2017
 * Description:
 */

public class RuntimeObject {

    public static void main(String[] args){

        Runtime r = Runtime.getRuntime();

        System.out.println("Total amount of memory: " + r.totalMemory());
        System.out.println("Free memory: " + r.freeMemory());
        System.out.println("Available processors: " + r.availableProcessors());


    }

}
