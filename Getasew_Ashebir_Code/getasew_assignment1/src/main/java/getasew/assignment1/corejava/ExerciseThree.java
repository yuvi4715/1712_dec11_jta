package getasew.assignment1.corejava;
// a program that declare two variables a & b and initialize them to true and false respectively and
//get the output of the following computations:

public class ExerciseThree {
	public static void main(String [] str) {
		boolean a, b;
		a= true; b = false;
		
		System.out.println(!a);
		System.out.println( a|b);
		System.out.println((!a&b)|(a&!b));
	}

}
