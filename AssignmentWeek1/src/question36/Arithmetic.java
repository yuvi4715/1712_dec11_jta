package question36;

public class Arithmetic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		String c = args[2];
		
		switch(c) {
		case "+":
			System.out.println(a + b);
			break;
		case "-":
			System.out.println(a - b);
			break;
		case "/":
			System.out.println(a / b);
			break;
		case "*":
			System.out.println(a * b);
			break;
		}
		

	}

}
