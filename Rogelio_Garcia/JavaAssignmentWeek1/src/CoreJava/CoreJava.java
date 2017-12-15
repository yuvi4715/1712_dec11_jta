package CoreJava;

public class CoreJava {
	// 1
	public static void one() {
		int a = 3;
		int b = 2;
		int add = a+b;
		int sub = a-b;
		int multi = a*b;
		int div = a/b;
		System.out.println(a + " + " + b + " = " + add);
		System.out.println(a + " - " + b + " = " + sub);
		System.out.println(a + " * " + b + " = " + multi);
		System.out.println(a + " / " + b + " = " + div);
	}
	// 2
	public static void two(int a, int b, int c) {
		if (a > b && a > c) System.out.print(a);
		else if (b > c) System.out.println(b);
		else System.out.println(c);
	}
	// 3
	public static void three() {
		boolean a = true;
		boolean b = false;
		System.out.println("!a = " + !a);
		System.out.println("a|b = " + (a||b));
		System.out.print("(!a & b) | (a & !b) = " + ((!a && b) || (a && !b))); 
	}
	public static void main(String[] args) {
		one();
		two(2,1,4);
		three();
	}
}
