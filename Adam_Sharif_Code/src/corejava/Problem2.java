package corejava;

public class Problem2 {

	public static void main(String[] args) {
		int x = 7;
		int y = 10;
		int z = 17;

		if (x > y && x > z)
			System.out.println(x + " is the greatest");
		else if (y > x && y > z)
			System.out.println(y + " is the greatest");
		else if (z > x && z > y)
			System.out.println(z + " is the greatest");
		else
			System.out.println("No greatest number");

	}

}
