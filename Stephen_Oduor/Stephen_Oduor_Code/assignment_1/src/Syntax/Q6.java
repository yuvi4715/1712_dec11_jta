package Syntax;

/**
 * Name: Stephen Omondi
 * Date: 12/10/2017
 * Description: Create an example of each control statement
 */

public class Q6 {

    public static void main(String[] args){

        int j = 0, k = 0;

        //Printing numbers from 0 - 4 demonstrating a for loop
        for(int i = 0; i < 5; i++){
            System.out.println(i);
        }

        //Printing numbers from 0 -4 demonstrating a while loop
        while(j < 5){
            System.out.println(j);
            j++;
        }

        //Printing numbers from 0 - 4 demonstrating a do while loop
        do{
            System.out.println(k);
            k++;
        }while (k < 5);

    }
}
