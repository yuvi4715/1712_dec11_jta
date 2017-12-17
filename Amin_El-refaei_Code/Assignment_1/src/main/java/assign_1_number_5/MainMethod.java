package assign_1_number_5;

public class MainMethod { //calls on methods in the OnlyMethods class and executes them

	public static void main(String[] args) {
		int x = 15; // creates an integer x and assigns it the value 15
		int y = 5;
		OnlyMethods m1 = new OnlyMethods(); // creates an instance of OnlyMethods which allows me to call upon the methods in that class
		m1.addNumbers(x, y); // calls on addNumbers method using the m1 instance that I just created
		m1.subtractNumbers(x, y); // "     subtractNumbers        "
		m1.multiplyNumbers(x, y); // "     multiplyNumbers          "
		m1.divideNumbers(x, y); // "         divideNumbers          "
		

	}

}
