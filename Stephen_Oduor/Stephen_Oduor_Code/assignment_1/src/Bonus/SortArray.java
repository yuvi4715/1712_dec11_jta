package Bonus;

/**
 * Name: Stephen Oduor
 * Date: 12/15/2017
 * Question: 58
 * Description: Write a method that sorts an integer array from least
 *              to greatest without using API functions
 */

public class SortArray {

    public static void main(String[] args){
        int[] array = {3,34,53,34,21,341,32,12,1,232};
        int tmp;

        printArray(array);


        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++)

                 if(array[i] < array[j]){
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
            }
        }

        printArray(array);
    }


    public static void printArray(int[] array){
        for(int i: array) {
            System.out.print(i + ",");
        }
        System.out.println();
    }


}


