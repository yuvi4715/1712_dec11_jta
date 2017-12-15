package easyCodingExercises;

public class CheckPassFail {
	
	private int mark;
	
	public CheckPassFail(int mark) {
		this.mark = mark;
		this.check();
	}
	
	
	public void check() {
		if (this.mark >= 50) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
	}
	
	public static void main(String[] args) {
		CheckPassFail test = new CheckPassFail(49);
	}
}
