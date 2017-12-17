package assign_1;

public class Number3 {
	
	public static void main(String[] args) {
		boolean a = true; // creates a boolean variable a, and assigns the value true
		boolean b = false;
		
		System.out.println("The output of !a is " + !a); // finds the result of !a (NOT a), and prints the value
		System.out.println("The output of a | b is " + (a | b)); // finds the result of a OR b and prints the value
		System.out.println("The output of (!a & b) | (a & !b) is " + ((!a & b) | (a & !b))); //finds the result of NOT a AND b, OR, a AND NOT b - prints the value
	}

}
