package Bonus;

/**
 * Name: Stephen Oduor
 * Date: 12/16/2017
 * Question: 65
 *Description: Write an application that prints Pascal's Triangle
 */
public class PascalTriangle {

    public static void main(String[] args){
        int n = 3;
        int k = 0;
        int i = 0;
        int result = 0;


        //printing spaces




        while(i <= n) {


            while (k <= i) {
                result = factorial(i) / (factorial(i) * factorial(i - k));
                System.out.print(" " + result + " ");
                k++;
            }
            System.out.println();
            i++;
            k = 0;
        }
    }

    public static int factorial(int n){
        int factorial = 0;
        for(int i = 0; i <= n; i++){

            if(n == 0 || n == 1){
                factorial = 1;
                break;
            }else {

                factorial = n * (i - 1);
            }
        }
        return factorial;
    }


}
