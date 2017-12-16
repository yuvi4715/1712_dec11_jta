package getasew.assignment1.classmembers;
/*
7.Class Members
Create a Customer class with:
At least 2 constructors
At least 2 overloaded methods
At least 1 static variable
At least 2 static methods
At least 1 final variable
 */
public class Customer {
	private String first_name;
	private String last_name;
	private String phone_number;
	private int age;
	private int id;
    private static int number_of_customer =0;
    private static final String BUSINESS_NAME = "Joe Pizza";
	public Customer(){ }
	public Customer(String fname,String lname, String phnumber,int age){
		first_name = fname;
		last_name = lname;
		phone_number = phnumber;
		this.age = age;
		number_of_customer += 1;
		id = number_of_customer;
	}
	public String getCustomerName() {
		return  first_name+" "+last_name;
	}
	public int getCustomerAge() {
		return age;
	}
	public String getCustomerPhoneNumber() {
		return phone_number;
	}
	public void updateCustomerInfo(String phnumber) {
		phone_number = phnumber;
	}
	public void updateCustomerInfo(String fname,String lname, String phnumber,int age) {
		first_name = fname;
		last_name = lname;
		phone_number = phnumber;
		this.age = age;
	}
	public static int getNumberOfCustomer() {
		return number_of_customer;
	}
	public static int getNumberOfCustomerWithIdless(Customer fam ){
		return fam.id;	
	}
	public static String getTheBusineesName() {
		return BUSINESS_NAME;
		
	}

}
