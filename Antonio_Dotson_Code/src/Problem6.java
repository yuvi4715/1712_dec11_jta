/**
 * @author Antonio Dotson
 *
 */
public class Problem6 {

	/**
	 *  Use control statements  do while switch if else 
	 */
	public static void main(String[] args) {
		int a = 0;
		if (a >5) {
			System.out.println("More than 5");
		} else {
			System.out.println("Less than 5");
		}
		
		int b = 2;
		switch(b) {
		case 0:
		System.out.println("zero");
		break;
		case 1:
		System.out.println("One");
		break;
		case 2:
			System.out.println("Two");
			break;
			default:
				System.out.println("More than 2");
		}
		
		int num = 1;
		while (num <10 ) {
			System.out.println(num);
			num++;
		}
		int nume = 1;
		do {
			System.out.println(nume);
			nume++;
		}while (nume <10);
		
		for (int nums = 0; nums <6; nums++)
		{
			System.out.println(nums);
		
		}
		
		int[] roommates = {1,2,3,4,5,6};
		for (int element: roommates)
		{
			System.out.println(element);
		}
		
		for (int c = 0; c<10; c++) {
			if(c==9)break;
			System.out.println("Loop complete!");
		}
		
		for (int d=0;d<10;d++) {
			if(d==7)continue;
			System.out.println(d);
		}
	}

}
