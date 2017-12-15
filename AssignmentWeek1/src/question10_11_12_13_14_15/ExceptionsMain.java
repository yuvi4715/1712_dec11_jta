package question10_11_12_13_14_15;

public class ExceptionsMain {

	public static void main(String[] args) throws CustomException {
		// TODO Auto-generated method stub
		CustomExceptionThrower cet = new CustomExceptionThrower();
		//cet.throwCustomException();
		//cet.throwCatchCustomException();
		//cet.duckException();
		cet.sysEnd(); // finally block doesn't run. It's not supposed to
	}

}
