//Antonio Dotson - Problem 2
public class FindGreatest {
  int x;
  int y;
  int z;
	  // created 3 variables and used the Short-circuit Operators to determine which value was greater
  public void FindNumber (int x, int y, int z) {
	  this.x = x;
	  this.y = y;
	  this.z = z;
	  if ( x >  y && x > z) {
		  //print out number
     	 System.out.println(x);
      }else if  (y > x && y > z){
     	 System.out.println(y);
      }else if (z > x && z > y) {
     	 System.out.println(z);
      }
 
	  
	  
  }
// called class and put in variables to find the largest number.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       FindGreatest num1 = new FindGreatest();
        num1.FindNumber(15,1,17);
	}
}
