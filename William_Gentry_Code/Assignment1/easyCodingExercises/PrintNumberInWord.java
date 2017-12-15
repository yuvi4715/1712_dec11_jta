package easyCodingExercises;

public class PrintNumberInWord {

	
	private int number;
	
	public PrintNumberInWord(int number) {
		this.number = number;
		this.print();
	}
	
	public void print() {
		if (this.number > 9 || this.number < 1) {
			System.out.println("OTHER");
		} else {
			if (this.number == 1) { 
				System.out.println("ONE");
			} else if (this.number == 2) {
				System.out.println("TWO");
			} else if (this.number == 3) {
				System.out.println("THREE");
			} else if (this.number == 4) {
				System.out.println("FOUR");
			} else if (this.number == 5) {
				System.out.println("FIVE");
			} else if (this.number == 6) {
				System.out.println("SIX");
			} else if (this.number == 7) {
				System.out.println("SEVEN");
			} else if (this.number == 8) {
				System.out.println("EIGHT");
			} else {
				System.out.println("NINE");
			}
		}
	}
	
	public static void main(String[] args) {
		PrintNumberInWord test = new PrintNumberInWord(11);
	}
}
