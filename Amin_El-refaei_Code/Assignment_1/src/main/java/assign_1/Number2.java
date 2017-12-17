package assign_1;

public class Number2 {

	
	public static void main(String[] args) {
		int x = 350; // creates an integer x and assigns a value of 350
		int y = 400;
		int z = 175;
		
		if (x > y && x > z) // if x is larger than y AND x is larger than z
			System.out.println("x is the largest number");
		else if (y > x && y > z) // if y is larger than x AND y is larger than z
			System.out.println("y is the largest number");
		else
			System.out.println("z is the larget number");	
		
	}
	

}
