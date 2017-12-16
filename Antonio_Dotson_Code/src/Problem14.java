//Antonio Dotson
public class Problem14 {
// using try and catch to catch error handling
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method 
		Problem14 a1 = new Problem14();
		try {
			a1.divide();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ArithmeticException e) {
			System.out.println("Your Error was caught");
		}finally {
			System.out.println("I caught your error too");
		}

	}
	
	public void divide () throws Exception {
			int x =15;
			int quotient = x / 0;
			System.out.println(quotient);
	}

}
