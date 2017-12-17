package ExceptionEx;

public class MyDivisionByZeroException extends Exception {

    public MyDivisionByZeroException(){
        super("Cannot divide by zero");
    }

    public MyDivisionByZeroException(String st){
        super(st);
    }

}
