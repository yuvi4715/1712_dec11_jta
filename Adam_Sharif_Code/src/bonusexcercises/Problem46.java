package bonusexcercises;

public class Problem46 {

	public static void main(String[] args) {
		
		swap(5,7);

	}
	public static void swap(int num1, int num2) {
		
		num1 = num1 + num2;
		num2 = num1 - num2;
		num1 = num1 - num2;
		System.out.println("Swapping x = " + num1 + " y = " + num2);
		
	}

}
