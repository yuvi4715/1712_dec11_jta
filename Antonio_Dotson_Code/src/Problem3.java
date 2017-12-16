//author Antonio Dotson
public class Problem3 {
boolean a = true;
boolean b = false;
//create variable to be evaluated
public void realValues (boolean a, boolean b) {
	this.a = a;
	this.b = b;
	System.out.println(!a);
	System.out.println(a|b);
	System.out.println((!a&b) | (a&!b));
}

	/**
	 * printing out solution in main method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Problem3 num3 = new Problem3();
    num3.realValues(true, false);
	}

}
