package classmembers;

public class Customers {	//#4
	static int x;
	final int y;
	
	public Customers() {
		Customers.x = 1;
		this.y = 1;
	}
	public Customers(int x, int y) {
		Customers.x = x;
		this.y = y;
	}
	
	public void add() {
		int z = x + y;
	}
	
	public void add(int a) {
		int z = x + a;
	}
}
