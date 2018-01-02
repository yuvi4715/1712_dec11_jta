package multithreading;

import java.util.HashSet;
import java.util.Set;

public class RunnableObj30 implements Runnable {

	@Override
	public void run() {
		incrementer();
	}
	
	private synchronized void incrementer() {
		int a = 1;
		Set<Integer> localset = new HashSet<>();
		for (int i = 0; i < 1000; i++) {
			localset.add(a);
			a++;
		}
		System.out.println(localset.toString());
	}
}