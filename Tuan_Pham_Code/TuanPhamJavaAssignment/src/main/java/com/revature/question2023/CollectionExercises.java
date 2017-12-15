package com.revature.question2023;

import java.util.*;

public class CollectionExercises {

	/*
	21.	Create an ArrayList, LinkedList, HashMap, TreeSet, and a HashSet. Insert 3 objects into each.
	22.	Iterate over each collection and print each object.
	23.	Sort the collections and compare the original to the sorted collection.
	*/
	ArrayList<Integer> arr = new ArrayList<Integer>();
	LinkedList<Integer> ll = new LinkedList<Integer>();
	HashMap<Integer, String> hm = new HashMap<Integer, String>();
	TreeSet<Integer> ts = new TreeSet<Integer>();
	HashSet<Integer> hs = new HashSet<Integer>();
	
	public void insertIntoCollections() {
		// Insert into ArrayList
		arr.add(19);
		arr.add(15);
		arr.add(20);
		
		// Insert into LinkedList
		ll.add(4);
		ll.add(6);
		ll.add(5);
		
		// Insert into HashMap with key and value
		hm.put(1, "john");
		hm.put(5, "sarah");
		hm.put(3, "bob");
		
		// Insert into TreeSet
		ts.add(100);
		ts.add(90);
		ts.add(40);
		
		// Insert into HashSet
		hs.add(-1);
		hs.add(-5);
		hs.add(-10);
	}
	
	public void printCollections() {
		// Print ArrayList
		for (int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println("");
		
		// Print LinkedList
		for (int e : ll) {
			System.out.print(e + " ");
		}
		System.out.println("");
		
		// Print HashMap
		Set<Integer> keys = hm.keySet();
		for (int key : keys) {
			System.out.println(key + ", " + hm.get(key));
		}
		
		// PrintTreeSet
		for (int e : ts) {
			System.out.print(e + " ");
		}
		System.out.println("");
		
		// Print HashSet
		for (int e : hs) {
			System.out.print(e + " ");
		}
		System.out.println("");
	}
	
	public void sortCollections() {
		// Sorting ArrayList
		Collections.sort(arr);
		
		// Sorting LinkedList
		Collections.sort(ll);
		
		// Sorting HashMap
		// HashMap cannot be sorted but could be if converted toTreeMap
		System.out.println("HashMap cannot be sorted");
		
		// Sorting TreeSet
		// TreeSet sorts by default
		
		// Sorting HashSet
		System.out.println("HashSet cannot be sorted");
		
		System.out.println("Collections sorted");
	}
		
	public static void main(String[] args) {
		CollectionExercises col = new CollectionExercises();
		col.insertIntoCollections();
		col.printCollections();
		col.sortCollections();
		col.printCollections();

	}

}
