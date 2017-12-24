
public class Core_Java {

	public static class Question_1{
		static int a = 12;
		static int b = 17;
		static int result;
		
		public static void add() {
			result = a+b;
			System.out.println(result);
		}
		
		public static void subtract() {
			result = a-b;
			System.out.println(result);
		}
		
		public static void multiply() {
			result = a*b;
			System.out.println(result);
		}
		
		public static void divide() {
			result = a/b;
			System.out.println(result);
		}
		
	}
	
	
	public static class Question_2{
		public static void print_greatest(int a, int b, int c) {
			int current_greatest = a;
			if (b > a && b > c) {
				current_greatest = b;
			}
			else if (c > a && c > b) {
				current_greatest = c;
			}
			System.out.println("Greatest of the three numbers: " + current_greatest);
		}
	}
	
	public static class Question_3{
		static boolean a = true;
		static boolean b = false;
		
		public static boolean computation_1(){
			if (!a) {
				System.out.println("True");
			}
			else {
				System.out.println("False");
			}
			return (!a);
		}
		
		public static boolean computation_2() {
			if (a || b) {
				System.out.println("True");
			}
			else {
				System.out.println("False");
			}
			return (a || b);
		}
		
		public static boolean computation_3() {
			if ((!a && b) || (a && !b)) {
				System.out.println("True");
			}
			else {
				System.out.println("False");
			}
			return ((!a && b) || (a && !b));
		}
	}
	
	public static void main(String args[]) {
		System.out.println("Adding, subtracting, multiplying, and dividing with: 12 and 17");
		Question_1.add();
		Question_1.subtract();
		Question_1.multiply();
		Question_1.divide();
		
		Question_2.print_greatest(1, 2, 3);
		
		Question_3.computation_1();
		Question_3.computation_2();
		Question_3.computation_3();
	}
	
}

