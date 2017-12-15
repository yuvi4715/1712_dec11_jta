package advancedCodingExercises;

public class IsArmstrong {
	private int n;
	private int remainder;
	
	public IsArmstrong(int num) {
		this.n = num;
		if (this.isArmstrong()) {
			System.out.println(num + " is Armstrong");
		} else {
			System.out.println(num + " is not Armstrong");
		}
	}
	
	public boolean isArmstrong() {
		double product = 0;
		for (int i = this.n; i > 0; i/=10) {
			remainder = i % 10;
			product += remainder*remainder*remainder;
		}
		if (product == this.n) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		IsArmstrong test;
		for (int i = 0; i < 1000; i++) {
			test = new IsArmstrong(i);
		}
		
	}

}
