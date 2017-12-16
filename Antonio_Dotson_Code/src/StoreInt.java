//Antonio Dotson - Problem 29 & 30
class StoreInt extends Thread {
	int y;
    int z;
  // class extends thread   
	StoreInt() {
	}

	StoreInt(String threadName) {
		super(threadName); // Initialize thread.
		start();
	}
	public void run() {
		//Display info about this particular thread
		// loop 1000 times
		for (int x=0; x<=1000; x++ ) {
		    y = increaseInt(x);
			z = storeIncreaseNumber(x);
			}
		//print thread
		System.out.println(Thread.currentThread().getName()+" "+ "is now started & Running! increasing number by 1 to " +" "+ y +" add"+" "+"storing it" +" "+z);
	   }

	//increased number
 public static int increaseInt(int x) {
	 x++;          
	 return x;
 }
 //stores increased number
 public static int storeIncreaseNumber(int x)  {
	 x = increaseInt(x);
	 return x;
	 
 }
}

