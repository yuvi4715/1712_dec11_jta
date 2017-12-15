package core;

public class Core {
	public void core1() {	//#1
		int x = 2, y = 1;
		int zadd = x+y;
		int zsub = x-y;
		int zmult= x*y;
		int zdiv = x/y;
	}
	
	public void core2() { //#2
		int a = 0,
			b = 0,
			c = 0;
		if (a > b && a > c) {
			System.out.printf("Value of a: %d\n", a);
		}
		else if (b > a && b > c) {
			System.out.printf("Value of b: %d\n", b);
		}
		else {
			System.out.printf("value of c: %d\n", c);
		}
	}
	
	public void core3() { //#3
		boolean a = true, b = false;
		System.out.printf("!a: %b\n", !a);
		System.out.printf("a | b: %b\n", a|b);
		System.out.printf("(!a & b) | (a & !b): %b\n", (!a & b) | (a & !b));
	}
}
