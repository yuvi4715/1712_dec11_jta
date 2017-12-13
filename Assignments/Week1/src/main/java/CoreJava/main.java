package CoreJava;

public class main {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		cal.message();
		
		System.out.println("Hardcoded calculator");
		cal.hardcodedCalculator();	
		
		System.out.println("\nDeclaration of two values, a = true, and b = false");
		cal.displayBooleanValues();
	}

}
