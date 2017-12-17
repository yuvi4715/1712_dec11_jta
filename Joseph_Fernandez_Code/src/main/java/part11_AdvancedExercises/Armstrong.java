package part11_AdvancedExercises;

public class Armstrong {
	
	private int n;
	private int rem;
	
	public Armstrong(int num) {
		this.n = num;
		
		if (this.isArmstrong()) {
			System.out.println(num + " is an Armstrong number");
		}
	}

	public static void main(String[] args) {
		Armstrong test;
		
		for (int i = 0; i <= 500; i++) {
			test = new Armstrong(i);
		}
	}
	
	public boolean isArmstrong() {
		
		double product = 0;
		
		for (int i = this.n; i > 0; i/=10) {
			rem = i % 10;
			product += rem*rem*rem;
		}
		
		if (product == this.n) {
			return true;
		} else {
			return false;
		}
	}
}
