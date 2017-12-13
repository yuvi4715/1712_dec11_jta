package coreJava;

public class CoreJava2 {

	public static void main(String[] args) {
		FindGreatest(5,6,4);
	}
	
	public static void FindGreatest(int x,int y,int z) {
		int grt = (x > y && x > z) ? x : (y>z ? y : z);
		System.out.println("The greatest number is " + grt);
	}
}
