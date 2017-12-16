//Antonio Dotson
public class Problem19 {
// adding strings and calling garbage collector.
	public static void main(String[] args) {
	       String st1 = "20";
	       String st2 = "10";
	       int num1 = Integer.parseInt(st1);
	       int num2 = Integer.parseInt(st2);
	       addMoreNumbers(num1,num2);

		}
	// called to collect garbage but we dont know when
	     public static void addMoreNumbers(int x, int y) {
	    	 int z = (x + y);
	    	 System.out.println("Adding two strings" +" "+x+"+"+y+ " = "+z);
	    	 System.gc();
	     }
	}


