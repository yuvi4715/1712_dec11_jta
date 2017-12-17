package assign_1; // this class contains the code for number 36

public class Arithmetic {

	public static void main(String[] args) {
		int answer = 0; // created variable named answer and initialized it to 0
		Integer.parseInt(args[0]); // converted args[0] from String to Integer
		Integer.parseInt(args[1]);

		if (args[2].equalsIgnoreCase("+")) { // if args[2] is a + sign, add args[0] and args[1]
			answer = Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
		} else if (args[2].equalsIgnoreCase("-")) { // if args[2] is a - sign, get the difference between args[0] and args[1]
			answer = Integer.parseInt(args[0]) - Integer.parseInt(args[1]);
		} else if (args[2].equalsIgnoreCase(".classpath")) { // .classpath is needed here because when I put the multiplication sign, sts was seeing .classpath because * is a wildcard symbol 
			answer = Integer.parseInt(args[0]) * Integer.parseInt(args[1]);
		} else if (args[2].equalsIgnoreCase("/")) {
			answer = Integer.parseInt(args[0]) / Integer.parseInt(args[1]);
		}
		System.out.println(answer); // print the answer
	}

}
