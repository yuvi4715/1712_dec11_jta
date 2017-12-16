//Antonio Dotson
public class Problem18 {
//created two strings and changed to integers
	public static void main(String[] args) {
       String st1 = "20";
       String st2 = "10";
       int num1 = Integer.parseInt(st1);
       int num2 = Integer.parseInt(st2);
       addMoreNumbers(num1,num2);

	}
     public static void addMoreNumbers(int x, int y) {
    	 int z = (x + y);
    	 System.out.println("Adding two strings" +" "+x+"+"+y+ " = "+z);
     }
}
