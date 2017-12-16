package getasew.assignment1.syntax;

public class ExerciseFour {
	static int add (int a, int b) {
		return a + b;
	}
	static int subtract(int a, int b) {
		return a-b;
	}
	static int multiply(int a, int b) {
		return a*b;
	}
   static int divide(int a, int b) {
	   return a/b;
   }
   public static void main(String [] str) {
	   int a = 90;
	   int b = 10;
	   System.out.println(add(a,b));
	   System.out.println(subtract(a,b));
	   System.out.println(multiply(a,b));
	   System.out.println(divide(a,b));
   }
}
