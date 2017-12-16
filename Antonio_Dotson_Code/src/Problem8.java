/**
 * @author Antonio Dotson
 *
 */
public class Problem8 {

	
	/**
	 * uses customer.java that was created for problem 7 and uses the methods from the customer class
	 */
	public static void main(String[] args) {
	Customer brandNew = new Customer("AntonioDotson", 99999999);
	String myEmail = brandNew.email("antoniodotson@mypenmail.com");
	String myAddress = brandNew.address("22722 Carter Moir Katy,TX 77449");
	System.out.println(myEmail);
	System.out.println(myAddress);
	Customer.newEmployee();
	Customer.graduatingEmployee();
	Customer.idNum = 10101;
	}
}