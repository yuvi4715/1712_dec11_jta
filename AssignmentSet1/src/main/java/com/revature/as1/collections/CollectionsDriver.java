package com.revature.as1.collections;
import java.security.KeyStore.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class CollectionsDriver {

	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(1);
		ar.add(Integer.parseInt("20"));
		ar.add(Integer.parseInt("20"));
		ar.add(55);
		
		LinkedList<String> ll = new LinkedList<String>();
		
		ll.add("This is the first line.");
		ll.add("This is not the first line.");
		ll.add("This is not the first line.");
		ll.push("This element cut in line, making the next element a lie.");
		
		TreeSet<Double> ts = new TreeSet<Double>();
		
		ts.add(.11);
		ts.add(.11); //doesn't actually add anything
		ts.add(110.0);
		ts.add(3.14159);
		
		Map<Integer,Float> hm = new HashMap<Integer,Float>();
		hm.put(1, 1.1f);
		hm.put(2, 2.33f);
		hm.put(1, 11f); //replaces 1.1 with 11
		hm.put(3, 88f);
		
		HashSet<String> hs = new HashSet<String>();
		
		hs.add("Are we, we are");
		hs.add("Are we, we are"); //isn't actually added, duplicate
		hs.add("The waiting unknown.");
		hs.add("And I'm just dancing on my own.");
		
		for(Integer i : ar) {
			System.out.println("Array List elements: " + i);
		}
		
		for(String s : ll) {
			System.out.println("Linked List elements: " + s);
		}
		
		for(Double d : ts) {
			System.out.println("Tree Set elements: " + d);
		}
		
		for(Map.Entry<Integer,Float> cs : hm.entrySet()) {
			System.out.println("Hash Map key: " + cs.getKey() + ". Element: " + cs.getValue());
		}
		
		for(String s : hs) {
			System.out.println("Hash Set element: " + s);
		}
		
		System.out.println("Sorting everything below.");
		
		Collections.sort(ar);
		Collections.sort(ll);
		//TreeSets are sorted on insert due to being Binary Trees
		List<Map.Entry<Integer, Float>> hms = hm.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
		List<String> hss = new ArrayList<String>(hs); //HashSets do not guarantee any ordering, and cannot be naturally sorted.
		Collections.sort(hss);



		
		for(Integer i : ar) {
			System.out.println("Array List  sorted elements: " + i);
		}
		
		for(String s : ll) {
			System.out.println("Linked List sorted elements: " + s);
		}
		
		for(Double d : ts) {
			System.out.println("Tree Set 'sorted' elements: " + d);
		}
		
		for(Map.Entry<Integer,Float> cs : hms) {
			System.out.println("Hash Map sorted key: " + cs.getKey() + ". Element: " + cs.getValue());
		}
		
		for(String s : hss) {
			System.out.println("Hash Set sorted element: " + s);
		}
		
		
	}
	
}
