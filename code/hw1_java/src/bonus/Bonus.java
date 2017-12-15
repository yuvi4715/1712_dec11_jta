package bonus;

import java.util.*;

public class Bonus {
	public void intswap() { //#46 
		int a = 53,
			b = 867;
		
		System.out.println("Before, a: " + a + ", b: " + b);
		a = a + b;	///done by adding nd subtracting
		b = a - b;
		a = a - b;
		System.out.println("After.  a: " + a + ", b: " + b);
		
	}
	
	public void findMidNode() { //#47, done by using fast and slow pointers
		Node head = new Node(1);
		head.appendToTail(2);
		head.appendToTail(3);
		head.appendToTail(4);
		head.appendToTail(5);
		head.appendToTail(6);
		
		Node fastNode = head;
		Node slowNode = head;
		
		while(fastNode.next != null) {
			fastNode = fastNode.next;
			if (fastNode.next != null) {
				fastNode = fastNode.next;
				slowNode = slowNode.next;	//if ll has even length finds the first of the middle 2 here
			}
			//second of middle 2 here
		}
		
		System.out.println("Middle node is " + slowNode.data);
	}
	
	public int Factorial(int n) {	//#48
		if (n==0) return 1; //base case
		return (n * Factorial(n-1));
	}
	
	public String substring(String str, int startIdx, int endIdx) {	//#49
		String substr = "";
		
		for(int i=startIdx; i<=endIdx; i++) {
			substr += str.charAt(i);
		}
		return substr;
	}
	
	public void deadlock() { 
		Deadlock.Thread1 t1 = new Deadlock.Thread1();
		Deadlock.Thread2 t2 = new Deadlock.Thread2();
		t1.start();
		t2.start();
		System.out.println("Locking Done");
		
/*		Deadlock d1 = new Deadlock("t1");
		Deadlock d2 = new Deadlock("t2");
		
		new Thread(new Runnable() {
            public void run() { d1.request(d2); }
        }).start();
		
		new Thread(new Runnable() {
            public void run() { d2.request(d1); }
        }).start();
		System.out.println("Locking Done");*/
	}
}
