package bonus;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import fileio.Employee;

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
	
	public void deadlock() { //#50
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
	
	public void livelock() {	//#51
		Worker worker1 = new Worker("w1", true);
        Worker worker2 = new Worker("w2", true);
        Resource s = new Resource(worker1);

        new Thread(() -> {
            worker1.work(s, worker2);
        }).start();

        new Thread(() -> {
            worker2.work(s, worker1);
        }).start();
	}
	
	public void reverseNum(int n) {	//#52
		int numReversed = 0;
		while (n != 0) {
			int digit = n%10;
			numReversed = numReversed*10 + digit;
			n = n/10;
		}
		
		System.out.println(numReversed);
	}
	
	public void findDuplicate() {	//#53
		int N = 10;
		int[] arr = new int[N];	//assuming one duplicate num
		
		for (int i=0; i<arr.length-1; i++) 
			arr[i] = i+1;	//range 1-N
		arr[N-1] = 6;	//add dupe to last idx
		
		//using sum of the range to find dupe
		int total = 0, sum = 0;	//total of the range, sum of array
		for (int i=0; i<N; i++) {
			total += i+1;
			sum += arr[i];
		}
		
		System.out.println((N)*(N-1)/2 + " " + sum);
		int dup = sum - (N)*(N-1)/2;	//sum from 1-9 difference is the duplicate num
		System.out.println(dup);
		
	}
	
	public void findRepeatWords() {	//#54
		BufferedReader br = null;
		String filename = "testfile2.txt";
		String filepath = System.getProperty("user.dir") + "\\" + filename;
		String line;
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		
		try {
			br = new BufferedReader(new FileReader(new File(filename)));
			while((line = br.readLine()) != null){	//read line
	            StringTokenizer st = new StringTokenizer(line);
	            while (st.hasMoreTokens()) {	//read each word
	            	String word = st.nextToken().replaceAll("\\.", "").toLowerCase();
	            	if (counts.containsKey(word))	//if already in map, increment val
	            		counts.put(word, counts.get(word)+1);	
	            	else							//else new entry into map											
	            		counts.put(word, 1);
	            }
			} //while
			
			for (String key: counts.keySet())
				if (counts.get(key) > 1)
					System.out.print(key + ": " + counts.get(key) + " | ");
			System.out.println();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	//finally
	}
	
	public void findRepeatChars(String str) {	//#55
		HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
		char[] strArr = str.toCharArray();
		for(int i=0; i<strArr.length; i++) {
			char c = strArr[i];
			if (counts.containsKey(c))
				counts.put(c, counts.get(c)+1);
			else
				counts.put(c, 1);
		} //while
		
		System.out.print("Repeat chars in sentance, ");
		for (Character key: counts.keySet())
			if (counts.get(key) > 1)
				System.out.print(key + ": " + counts.get(key) + " | ");
		System.out.println();
	}

	public void checkOddEven(int n) {	//#56
		if ((n & 1) == 1) //first bit is set = odd
			System.out.println(n + " is odd");
		else
			System.out.println(n + " is even");
	}

	public void isPalindrome(String str) {	//#57
		String strReversed = new StringBuilder(str).reverse().toString();
		System.out.println("Original String: " + str);
		System.out.println("Reversed String: " + strReversed);
	}
	
	public void sortInsertion(int[] arr) {	//#58
		int i = 1, j;
		while (i < arr.length) {
			j = i;
			while (j>0 && arr[j-1]>arr[j]) {
				int temp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = temp;
				j = j-1;
			}
			i++;
		}

		System.out.print("[");
		for (i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			if (i==arr.length-1)
				System.out.println("]");
			else
				System.out.print(", ");
		}
	}
	
	public void findCommon(int [] a1, int[] a2) {	//#59 naive solution
		List<Integer> commons = new ArrayList<Integer>();
		
		for (int i=0; i<a1.length; i++) {
			for(int j=0;j<a2.length;j++){
                if(a1[i]==a2[j])
                    commons.add(a2[j]);
			} //for
		} //for
		
		for (int i: commons)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public void findDistinct(int[] arr) { //#61
		HashMap<Integer, Integer> distincts = new HashMap<Integer, Integer>();
		
		for (int i=0; i<arr.length; i++) {
			if (distincts.containsKey(arr[i])) {
				distincts.put(arr[i], distincts.get(arr[i])+1); 
			}
			else
				distincts.put(arr[i], 1);
		}
		
		System.out.print("Distinct Values: [ ");
		for (int i: distincts.keySet()) {
			if (distincts.get(i)>1) 
				continue;
			System.out.print(i + " ");
		}
		System.out.println("]");
	}
	
	public void findDistinctWords() { //#62 like 54
		BufferedReader br = null;
		String filename = "testfile2.txt";
		String filepath = System.getProperty("user.dir") + "\\" + filename;
		String line;
		HashMap<String, Integer> counts = new HashMap<String, Integer>();
		
		try {
			br = new BufferedReader(new FileReader(new File(filename)));
			while((line = br.readLine()) != null){	//read line
	            StringTokenizer st = new StringTokenizer(line);
	            while (st.hasMoreTokens()) {	//read each word
	            	String word = st.nextToken().replaceAll("\\.", "").toLowerCase();	//strip period and lower case
	            	if (counts.containsKey(word))	//if already in map, increment val
	            		counts.put(word, counts.get(word)+1);	
	            	else							//else new entry into map											
	            		counts.put(word, 1);
	            }
			} //while
			
			for (String key: counts.keySet())
				if (counts.get(key) == 1)
					System.out.print(key + " | ");
			System.out.println();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	//finally
	}

	public void computePi() {	//#63 using Leibniz infinite series
		double denominator = 1;
		int iterations = 100000;
		double sum = 0;
		for (double i=0; i<iterations; i++) {
			
			if (i % 2 == 0)
				sum += (1) * (4 / (2*i+1));
			else 
				sum += (-1) * (4 / (2*i+1));
		}
		
		System.out.println("Pi approx: " + sum + "	" + iterations + " iterations");
		System.out.println("Math.PI  : " + Math.PI);
	}
	
	public void printDog() {	//#64
		System.out.println("          '__'");
		System.out.println("          (\u00a9\u00a9)");
		System.out.println("  /========\\/");
		System.out.println(" / || %% ||");
		System.out.println("*  ||----||");
		System.out.println("   \u00a5\u00a5    \u00a5\u00a5");
		System.out.println("   \"\"    \"\"");
	}
	
	public void printPascals() {	//#65
		
		int rows = 10;
		int[] prevRow;
		int[] currRow = {1};
		System.out.println(1);
	
		prevRow = currRow;
		for (int i=2; i<=rows; i++) {
			currRow = new int[i];
			currRow[0] = 1;
			currRow[i-1] = 1;
			for (int j=1; j<i-1; j++) {
				currRow[j] = prevRow[j-1] + prevRow[j];
			}
			
			for (int k=0; k<currRow.length; k++)
				System.out.print(currRow[k] + " ");
			System.out.println();
			prevRow = currRow;
		}
	}
	
	public void numGuess() {
		int guess = -1;
		int num = (int) (Math.random() * 100);
		int trials = 1;
		
		Scanner kb = new Scanner(System.in);
		System.out.print("Guess a number: ");
		
		while(guess != num) {
			guess = kb.nextInt();
			if (guess == num)
				break;
			if (guess > num)
				System.out.print("Try lower.  Guess: ");
			else	//guess < num
				System.out.print("Try higher. Guess: ");
			trials++;
		}
		
		System.out.println("You guessed " + num + " in " + trials + " trials");
		kb.close();
	}
	
	

}

