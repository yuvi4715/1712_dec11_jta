package question46;

public class integerSwap {

	public static void main(String[] args) {
		int a = 246;
		int b = 369;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
//		System.out.println("a = " + b); 
//		System.out.println("b = " + a);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}

}
