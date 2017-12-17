package easycodingexcercises;

public class Arithmetic {

	public static void main(String[] args)
    {
	
		
        if(args.length==0)
        {
        System.out.println("No arguments are passed");
        }
        else
        {

        int int1=Integer.parseInt(args[0]);
        int int2=Integer.parseInt(args[1]);
        char char1=args[2].charAt(0);

        switch(char1)
        {
            case '+':
                System.out.println("Addition of "+int1+" and "+int2+" = "+(int1+int2));
                break;

            case '-':
                System.out.println("Subtraction of "+int1+" and "+int2+" = "+(int1-int2));
                break;

            case '*':
                System.out.println("Multiplication of "+int1+" and "+int2+" = "+(int1*int2));
                break;

            case '/':
                System.out.println("Division of "+int1+" and "+int2+" = "+(int1/int2));
                break;

            default:
                System.out.println("Please Enter '+', '-', '*', '/' operators only.");
        }
        }

    }

}