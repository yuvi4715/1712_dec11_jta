package sample;

public class CoreJava3 {

	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;
		System.out.println("!a = " + !a);
		System.out.println("a | b = "+(a | b));
		System.out.println("(!a & b) | (a & !b) = "+((!a & b) | (a & !b)));
	}

}
