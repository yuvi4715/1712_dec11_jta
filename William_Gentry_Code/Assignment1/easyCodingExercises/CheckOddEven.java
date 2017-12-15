package easyCodingExercises;

public class CheckOddEven {

	
	private int number;
	
	public CheckOddEven(int number) {
		this.number = number;
		this.oddOrEven();
	}
	
	public void oddOrEven() {
		if (this.number % 2 == 0) {
			System.out.println("EVEN");
		} else {
			System.out.println("ODD");
		}
	}
	
	public static void main(String[] args) {
		CheckOddEven test = new CheckOddEven(4);
	}
}
