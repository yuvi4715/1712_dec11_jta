package com.revature.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionsAreFun {

	List<String> al = new ArrayList<String>();
	List<String> ll = new LinkedList<String>();
	Map<String, String> hm = new HashMap<String, String>();
	Set<String> ts = new TreeSet<String>();
	Set<String> hs = new HashSet<String>();
	
	
	public static void main(String[] args) {
		
		CollectionsAreFun col = new CollectionsAreFun();
		col.fillCollection();
		col.iterateCollections();
		col.sortCollections();
	}
	
	private void sortCollections() {

		Collections.sort(al);
		Collections.sort(ll);
		
		//TreeSet is already sorted
		
		//sorting HashSet using a TreeSet
		Set<String> temp = new TreeSet<>(hs);
		hs = temp;
		
//		for(i, hm) {
//			
//		}
		
		
		System.out.println("============ AFTER SORTING: ============");
		iterateCollections();
	}

	private void iterateCollections() {
		
		System.out.println("ArrayList:");
		Iterator<String> ali = al.iterator();
		while(ali.hasNext()) {
			System.out.println(ali.next());
		}
		System.out.println();

		System.out.println("LinkedList:");
		Iterator<String> lli = ll.iterator();
		while(lli.hasNext()) {
			System.out.println(lli.next());
		}
		System.out.println();

		System.out.println("TreeSet:");
		Iterator<String> tsi = ts.iterator();
		while(tsi.hasNext()) {
			System.out.println(tsi.next());
		}
		System.out.println();

		System.out.println("HashSet:");
		Iterator<String> hsi = hs.iterator();
		while(hsi.hasNext()) {
			System.out.println(hsi.next());
		}
		System.out.println();
		
		System.out.println("HashMap:");
		for(String s: hm.values()) {
			System.out.println(s);
		}
		System.out.println();
		
	}

	void fillCollection() {
	
		String a = "Hello", b = "Goodbye", c = "How are you", 
				 one = "01", two = "02", three = "03";
		
		al.add(a);
		al.add(b);
		al.add(c);
		
		ll.add(a);
		ll.add(b);
		ll.add(c);
		
		ts.add(a);
		ts.add(b);
		ts.add(c);
		
		hs.add(a);
		hs.add(b);
		hs.add(c);
		
		hm.put(one, a);
		hm.put(two, b);
		hm.put(three, c);
		
	}
}
