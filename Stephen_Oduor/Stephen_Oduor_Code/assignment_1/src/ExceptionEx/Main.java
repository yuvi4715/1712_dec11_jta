package ExceptionEx;

import java.util.Scanner;

public class Main {



    public static void main(String[] args){
        int  numerator = 6;
        int denominator = 0;
        int result = 0;

        try {

            if(denominator == 0)
                throw new MyDivisionByZeroException();

            result = numerator / denominator;
            System.out.println(result);

        }catch (MyDivisionByZeroException e){
            System.out.println("In custom catch");
            System.out.println(e.toString());
            System.exit(0);

        }catch (Exception e){
            System.out.println("In Exception catch");
            System.out.println(e.toString());
            System.exit(0);

        }finally {
            System.out.println("Enter denominator greater than 0");
        }
    }


}

