package collections;

import java.util.*;

public class Collections21_22_23 {
	/*
	 * 21. Create an ArrayList, LinkedList, HashMap, TreeSet, and a HashSet. 
	 * Insert 3 objects into each.
	 * 
	 * 22. Iterate over each collection and print each object. 
	 * 
	 * 23. Sort the collections and compare the original to the sorted collection.
	 */
	
	public List<String> arrlist = new ArrayList<>();
	public List<String> linkedlist = new LinkedList<>();
	public Map<String, String> hm = new HashMap<>();
	public Set<String> ts = new TreeSet<>();
	public Set<String> hs = new HashSet<>();

	public static void main(String[] args) {
		Collections21_22_23 obj = new Collections21_22_23();
		obj.createCollections();
		obj.printCollections();
		obj.sortCollections();
		obj.printAgain();
	}
	
	public void createCollections() {
		String s = "hello";

		// add 3 objects to each collection
		for (int i = 0; i < 3; i++) {
			String t = s + (3-i);
			arrlist.add(t);
			hm.put(t, new String(t));
		}
		// easily add everything in arrlist to these collections
		linkedlist.addAll(arrlist);
		ts.addAll(arrlist);
		hs.addAll(arrlist);
	}
	
	public void printCollections() {
		// Iterate over each collection and print each object.
		System.out.println("Starting un-sorted printing...");
		System.out.println("Starting with ARRAYLIST:");
		for (String el : arrlist) {
			System.out.println(el);
		}
		System.out.println("Now printing LINKEDLIST elements:");
		for (String el : linkedlist) {
			System.out.println(el);
		}
		System.out.println("Now printing HASHMAP elements:");
		
		for (String el : hm.values()) {
			System.out.println(el);
		}
		System.out.println("Now printing TREESET elements:");
		for (String el : ts) {
			System.out.println(el);
		}
		System.out.println("Now printing HASHSET elements:");
		for (String el : hs) {
			System.out.println(el);
		}
		System.out.println("==============================");
	}
	
	public void sortCollections() {
		// Sort the collections and compare the original to the sorted collection.
		System.out.println("Starting sorted printing...");
		// Only the lists need sorting
		Collections.sort(arrlist);
		Collections.sort(linkedlist);
	}
	
	public void printAgain() {
		System.out.println("ArrayList: "+arrlist);
		System.out.println("LinkedList: "+linkedlist);
		// these maps/sets should be sorted already
		System.out.println("HashMap: "+hm);
		System.out.println("TreeSet: "+ts);
		System.out.println("HashSet: "+hs);
	}
	
}
