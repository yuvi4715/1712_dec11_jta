/**
 * @author Antonio Dotson - created methods to + - * and / and printed them out
 */
public class Problem4 {
	double x;
	double y;

	public int addNumber(int x, int y) {
		int z =  x + y;
		return z;
				
	}
	
	public int subNumber(int x, int y) {
		
		int z= x - y;
		return z;
	 
	}
	
	public int multNumber(int x, int y) {
		
		int z = x * y;
		return z;
	}
	
	public double divNumber(int x, int y) {
		int z = x/y;
		return z;
		
	}
	
	public double divNumber(double x, double y) {
		double ni =(x/y);
		return ni;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     // instance of objects
	Problem4 a1 = new Problem4();
	int showAdd = a1.addNumber(1, 5);
	int showSub = a1.subNumber(5, 1);
	int showMult = a1.multNumber(5, 5);
	double showDiv = a1.divNumber(10, 2);
	//Print
	System.out.println("Showing addition of two numbers" + " "+ showAdd);
	System.out.println("Showing substraction of two numbers" +" "+ showSub);
	System.out.println("Showing Multiplication of two numbers" +" "+ showMult);
	System.out.println("Showing division of two numbers" +" "+ showDiv);
	
	
	}
}
