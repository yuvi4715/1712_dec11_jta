//Antonio Dotson
public class Problem20 {
// Problem 20 - not sure what runtime objects so created some values.
	public static void main(String[] args) {
	
		      // print when the program starts
		      System.out.println("Program starting...");
              Problem20 ab = new Problem20();
              ab.newMoney("20","10");
              ab.oldMoney(2);
              ab.noMoney();
		    
		   }
	
	 public void newMoney(String x, String y) {  
		  int a = Integer.parseInt(x);
		  int b = Integer.parseInt(y);
		  int z = (a + b);
		  if (z > 10) {
		System.out.println("Your the greatest!");
		  } else {
			  System.out.println("Your just ok!");
		  }
	 }
	 
	 public void newMoney(int x, int y) {  
		  int z = (x + y);
		  if (z > 10) {
		System.out.println("Your the greatest!");
		  } else {
			  System.out.println("Your just ok!");
		  }
	 }

 
     public void oldMoney(int x) {
	   for (int i=0; i>x; i++) {
		   if (i > 10) {
			   System.out.println("Your almost there!");
		   }
	     } 
	   }
	   
	   public void noMoney() {
		   System.out.println("You gotta try harder");
	   }
	   
   }