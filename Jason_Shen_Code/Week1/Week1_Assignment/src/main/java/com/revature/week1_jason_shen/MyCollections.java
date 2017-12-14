package com.revature.week1_jason_shen;

import java.util.*;

public class MyCollections {
	
	// 21. Create an ArrayList, LinkedList, HashMap, TreeSet, and a HashSet. Insert 3 objects into each.
	// 22. Iterate over each collection and print each object.
	// 23. Sort the collections and compare the original to the sorted collection.


	static void myArrayList() {
		System.out.println("Initializing new arraylist of integers...");
		ArrayList<Integer> my_array_list = new ArrayList<Integer>();
		Integer to_add[] = {3000,150,200};
		for(int i = 0; i < to_add.length; i++) {
			my_array_list.add(to_add[i]);
			System.out.println("Added: " + to_add[i] + ",\nUpdated ArrayList: " + my_array_list);
		}
		
		System.out.println("Sorting arraylist...");
		@SuppressWarnings("unchecked")
		ArrayList<Integer> sorted_list = (ArrayList<Integer>) my_array_list.clone();
		Collections.sort(sorted_list);
		System.out.println("Sorted arraylist: " + sorted_list);
		
		System.out.println("Comparing to original...");
		if (my_array_list.equals(sorted_list)) {
			System.out.println("The lists are the same!");
		}
		else {
			System.out.println("The lists are different.");
		}
	}
	
	@SuppressWarnings("unchecked")
	static void myLinkedList() {
		System.out.println("Initializing new linkedlist of strings...");
		LinkedList<String> student_names = new LinkedList<String>();
		String names[] = {"Adam", "Bob", "Carl"};
		for(String name : names) {
			student_names.add(name);
			System.out.println("Added: " + name + ",\nUpdated LinkedList: " + student_names);
			
		}
		
		System.out.println("Sorting linkedlist...");
		LinkedList<String> sorted_list = (LinkedList<String>) student_names.clone();
		Collections.sort(sorted_list);
		System.out.println("Sorted arraylist: " + sorted_list);
		
		System.out.println("Comparing to original...");
		if (student_names.equals(sorted_list)) {
			System.out.println("The lists are the same!");
		}
		else {
			System.out.println("The lists are different.");
		}		
	}
	
	static void myHashMap() {
		
		System.out.println("Initializing new hashmap of string to integers...");
		HashMap<String, Integer> student_grades = new HashMap<String, Integer>();
		String names[] = {"April", "Beth", "Caitlyn"};
		Integer grades[] = {90, 85, 95};
		for (int i = 0; i < names.length; i++) {
			student_grades.put(names[i], grades[i]);
			System.out.println("Added: " + names[i] + ",\nUpdated HashMap: " + student_grades);
			
		}
		
		// Do we need to sort HashMap??? If need to, then can convert to TreeMap and sort
	}

	static void myTreeSet() {
		System.out.println("Initializing new treeset of strings...");
		TreeSet<String> unique_cities = new TreeSet<String>();
		String city_names[] = {"Boston", "Albany", "Boston"};
		for (String city : city_names) {
			System.out.println("Adding " + city + " to TreeSet...");
			if (!unique_cities.add(city)) {
				System.out.println(city + " already in TreeSet!");
			}
			else {
				System.out.println("Successfully added " + city);
			}
			System.out.println("Updated TreeSet: " + unique_cities);
		}
		
		// Comes sorted already!!
				
				
	}
	
	static void myHashSet() {
		System.out.println("Initializing new treeset of longs...");
		TreeSet<Long> student_ids = new TreeSet<Long>();
		Long ids[] = {11985190L, 10495109L , 11985190L};
		for (Long id : ids) {
			System.out.println("Adding " + id + " to HashSet...");
			if (!student_ids.add(id)) {
				System.out.println(id + " already exists in HashSet!");
			}
			else {
				System.out.println("Successfully added " + id);
			}
			System.out.println("Updated TreeSet: " + student_ids);
		}
					
	}
	
	// If you need sorted set, use TreeSet!
}
