package EasyCoding;

/**
 * Name: Stephen Oduor
 * Date: 12/12/2017
 * Question: Write a program called PrintNumberInWord which prints "ONE","TWO",..."NINE","OTHER"
 *           if the int variable is 1,2,...,9 or other respectively.Use(a) nested-if, (b) switch-case
 */

public class PrintNumberInWord {

    public static void main(String[] args){

        int variable = 5;

        if(variable == 1){
            System.out.println("ONE");
        }else if(variable == 2){
            System.out.println("TWO");
        }else if(variable == 3){
            System.out.println("THREE");
        }else if(variable == 4){
            System.out.println("FOUR");
        }else if(variable == 5){
            System.out.println("FIVE");
        }else if(variable == 6){
            System.out.println("SIX");
        }else if(variable == 7){
            System.out.println("SEVEN");
        }else if(variable == 8){
            System.out.println("EIGHT");
        }else if(variable == 9){
            System.out.println("NINE");
        }

        switch(variable){

            case 1:
                System.out.println("ONE");
                break;

            case 2:
                System.out.println("TWO");
                break;

            case 3:
                System.out.println("THREE");
                break;

            case 4:
                System.out.println("FOUR");
                break;

            case 5:
                System.out.println("FIVE");
                break;

            case 6:
                System.out.println("SIX");
                break;

            case 7:
                System.out.println("SEVEN");
                break;

            case 8:
                System.out.println("EIGHT");
                break;

            case 9:
                System.out.println("NINE");
                break;

            default:
                System.out.println("OTHER");
        }

    }

}
