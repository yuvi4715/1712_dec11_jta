package com.revature;

import java.util.ArrayList;
import java.util.Collections;

public class Collect {

	
	/*
	 * 	21.	Create an ArrayList, LinkedList, HashMap, TreeSet, and a HashSet. Insert 3 objects into each.
		22.	Iterate over each collection and print each object.
		23.	Sort the collections and compare the original to the sorted collection.

	 * */
	
	
	void arraylist(ArrayList<String> list1, ArrayList<Integer> list2, ArrayList<Character> list3) {
		
		//non sorted array
		showArray(list1, "1");
		showArray(list2, "2");
		showArray(list3, "3");
		//sorted array
		Collections.sort(list1);
		Collections.sort(list2);
		Collections.sort(list3);
		
		//iterating through array, ascending to descending, switch i++ to i-- for descending order
		iterateStuff(list1, "1");
		iterateStuff(list2, "2");
		iterateStuff(list3, "3");	
	}
	
	void linkedlist() {
		
	}
	
	void hmap() {
		
	}
	
	void tree() {
		
	}
	
	void hset() {
		
	}
	
	//this method is to display non sorted items in the array
	private void iterateStuff(ArrayList<?> list, String arry) {
		System.out.printf("Printing  sorted array %s\n", arry);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	// this method is to display sorted items in the array
	private void showArray(ArrayList<?> list, String arry) {
		System.out.printf("Printing none sorted array %s\n", arry);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));		
		}
	}
	
	
}
