package EasyCoding;

/**
 * Name: Stephen Oduor
 * Date: 12/12/2017
 * Description: Write a program called CheckOddEven which prints "Odd Number" if the int variable
 *              "number" is odd or "Even Number" otherwise
 */

public class CheckOddEven {

    public static void main(String[] args) {


        int num = 4;

        if (num % 2 == 0) {
            System.out.println("Even Number");
        }else{
            System.out.println("Odd Number");
        }
    }
}

