package Bonus;

public class SwappingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 34;
		int y = 24;
		
		x = x - y; // x is now 34
		y = x + y; // y is now 24
		x = y - x; // x is now 34
		
		System.out.println(x);
		System.out.println(y);
	}

}
