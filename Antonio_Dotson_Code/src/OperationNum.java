/*Problem number 5 
 * created a class that will simple add - subtract - multiply and divide and they all have a return type.
 */
/**
 * @author Antonio Dotson 
 *
 */
public class OperationNum {

	int x;
	int y;
//add
	public int addNum(int x, int y) {
		int z =  x + y;
		return z;
				
	}
	//subtract
	public int subNum(int x, int y) {
		
		int z= x - y;
		return z;
	 
	}
	// multiply
	public int multNum(int x, int y) {
		
		int z = x * y;
		return z;
	}
	// divide
	public double divNumb(int x, int y) {
		int z = x/y;
		return z;
		
	}
}
