package coreJava;

public class problem2 {
	
	public static int greatestNum(int a, int b, int c) {
		int greatest = 0;
		
		boolean aGreaterThanB = (a > b);
		boolean aGreaterThanC = (a > c);
		boolean bGreaterThanA = (b > a);
		boolean bGreaterThanC = (b > c);
		boolean cGreaterThanA = (c > a);
		boolean cGreaterThanB = (c > b);
		
		if (aGreaterThanB && aGreaterThanC) {
			greatest = a;
		} else if (bGreaterThanA && bGreaterThanC) {
			greatest = b;
		} else if (cGreaterThanA && cGreaterThanB) {
			greatest = c;
		}
		
		
		
		return greatest;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(greatestNum(101, 14, 3));
	}

}
