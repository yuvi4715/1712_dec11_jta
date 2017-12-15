package question21_22_23;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Collections;

public class DataCollections {
	int[] aL = new int[3];
	LinkedList<Integer> lL = new LinkedList<Integer>();
	HashMap<String, Integer> hM = new HashMap<String, Integer>();
	TreeSet<Integer> tS = new TreeSet<Integer>();
	HashSet<Integer> hS = new HashSet<Integer>();


	public void insertData() {
		aL[0] = 3;
		aL[1] = 1;
		aL[2] = 2;
		
		lL.add(3);
		lL.add(1);
		lL.add(2);
		
		hM.put("c", 3);
		hM.put("a", 1);
		hM.put("b", 2);
		
		tS.add(3);
		tS.add(1);
		tS.add(2);
		
		hS.add(3);
		hS.add(1);
		hS.add(2);
		
	}
	
	public void iterations() {
		
		for(int i = 0; i < aL.length; i++) {
			System.out.println(aL[i]); //prints out unsorted
		}
		System.out.println();
		lL.forEach(System.out::println); //prints out unsorted
		System.out.println();
		Iterator iterator = hM.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next().toString();
			String value = hM.get(key).toString();
			System.out.println(key + " " + value); //prints out sorted
		}
		
		System.out.println();
		
		iterator = tS.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().toString());//prints out sorted
		}
		
		System.out.println();
		
		iterator = hS.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next().toString()); //prints out sorted
		}
	}
	
	public void sorting() {
		System.out.println("Sorting Collections");
		Arrays.sort(aL);
		for(int i = 0; i < aL.length; i++) {
			System.out.println(aL[i]);  //Prints out sorted
		}
		System.out.println();
		Collections.sort(lL);
		lL.forEach(System.out::println); //Prints out sorted
		
		System.out.println(hM); //Already printed out sorted
		
		System.out.println(tS); //Already sorted
		
		System.out.println(hS); //Already sorted all in ascending order
		
	}
	
}
