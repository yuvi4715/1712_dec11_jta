/**
 * @author Antonio Dotson
 * throws to my custom type
 */
public class Problem12 {
	
	public static void main(String[] args) {
		Problem12 a1 = new Problem12();
		try {
			System.out.println("start try block");
			a1.quitMath();
		} catch (FailingException e) {
			System.out.println("start catch block");
			e.printStackTrace();
			// custom message
			e.getMessage();
		}
		System.out.println("end of try/catch block");
	}
// custom exception
public void quitMath() throws FailingException{
	throw new FailingException();
  }
}



