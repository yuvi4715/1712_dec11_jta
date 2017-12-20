package customExercises;

public class TheMatrix {
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static void main(String[] args) {
		printMatrixPattern();
	}
	
	public static void printMatrixPattern() {
		while(true) {
			for (int col=0;col<125;col++) {
				int randInt = (int) (Math.random()*2);
				System.out.print(randInt);
			}
			System.out.println();
		}
	}

}
