// Antonio Dotson 
public class Fibonacci {

	public static void main(String[] args) {
        //Problem number 40
		
		//System.out.println("Fibonacci iteration:");
        for (int n=0; n<=100; n++) {
        
       /*un-commnent line to run the Fibonacci iteration 
        System.out.printf("Fibonacci sequence(element at index %d) = %d \n", n, fibIteration(n));
        }
        */
       System.out.println("Fibonacci recursion:");
       System.out.printf("Fibonacci sequence(element at index %d) = %d \n", n, fibRecursion(n));
    }
    	}

    //Iteration method
    static long fibIteration(int n) {
       int x = 0, y = 1, z = 1;
        for (int i = 0; i < n; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return x;
    }

    //Recursive method
    static long fibRecursion(int  n) {
        if ((n == 1) || (n == 0)) {
           return n;
       }
      return fibRecursion(n - 1) + fibRecursion(n - 2);
    }
}

