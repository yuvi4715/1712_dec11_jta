package part07_Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeSet;

public class MainClass {

	public static void main(String[] args) {

		// ArrayList
		List<String> myAList = new ArrayList<String>();
		myAList.add("Joseph");
		myAList.add("Michelle");
		myAList.add("Kathryn");
		
		System.out.println("----- Contents of ArrayList -----");
		for(int i = 0; i < myAList.size(); i++) {
			System.out.println(myAList.get(i));
		}
		
		// LinkedList
		List<String> myLList = new LinkedList<String>();
		myLList.add("Matt");
		myLList.add("Kelby");
		myLList.add("Paolo");

		System.out.println("----- Contents of LinkedList -----");
		for(int i = 0; i < myLList.size(); i++) {
			System.out.println(myLList.get(i));
		}
		
		// HashMap
		HashMap<Integer, String> myHMap = new HashMap<Integer, String>();
		myHMap.put(1, "Eric");
		myHMap.put(2, "Anu");
		myHMap.put(3, "Doryin");

		System.out.println("----- Contents of HashMap -----");
		for (Entry<Integer, String> entry : myHMap.entrySet()) {
		    Object value = entry.getValue();
		    System.out.println(value);
		}
		
		// TreeSet
		TreeSet<Integer> myTSet = new TreeSet<Integer>();
		myTSet.add(5050);
		myTSet.add(15);
		myTSet.add(200);

		System.out.println("----- Contents of TreeSet -----");
		Iterator<Integer> itr = myTSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		// HashSet
		HashSet<String> myHSet = new HashSet<String>();
		myHSet.add("Sebastian");
		myHSet.add("Brandon");
		myHSet.add("Mario");

		System.out.println("----- Contents of HashSet -----");
		Iterator itr2 = myHSet.iterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}

		System.out.println("---------- Sorted Collections ----------");
		
	}
}
