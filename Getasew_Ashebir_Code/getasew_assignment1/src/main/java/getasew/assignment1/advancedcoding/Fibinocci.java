package getasew.assignment1.advancedcoding;
//40.Write a Java program to print the first 100 Fibonacci numbers 
//using iteration. Rewrite using recursion.

public class Fibinocci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testing fibinocci using iteration
		System.out.println("using iteration");
		printFibinocci(100);
		//testing fibnoccii using recursion
		System.out.println("Using recursion");
		for(int i=1;i<=100;i++) {
			System.out.printf("i = %d fib= %d%n",i,printRecurFib(i));
		}

	}
	//method that print first n fibonacci using iteration
	static void printFibinocci(int n) {
		// array to store the series of fibonacci numbers
		long [] arr = new long[n];
		int i=0;
		while(i<n) {
			if(i==0) {
			arr[i]= 1;
			}else if(i==1) {
			arr[i]= 2;
			} else {
				arr[i]= arr[i-1]+arr[i-2];
			}
			i++;
			
			
		}
		int j=1;
		for(long f: arr) {
			System.out.printf("iteration =%d fib= %d %n",j,f);
			j++;

		}
	}
	// ruturn the first n fibonacci series using recursion
	static long printRecurFib(int n) {
		if(n==1) {
			return 1;

		} else if(n==2) {
			return 2;
		} else {
			return printRecurFib(n-1) + printRecurFib(n-2);
		}



	}

}
