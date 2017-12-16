public class Problem11{
	// Antonio Dotson throws an exception from custom 
	public static void main(String[] args) {
		Problem11 a1 = new Problem11();
		try {
			a1.quitMath();
		} catch (FailingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
	}

public void quitMath() throws FailingException{
	throw new FailingException();
  }
}