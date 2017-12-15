package com.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;

public class Problem21thru23 {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		LinkedList<Integer> l = new LinkedList<Integer>();
		TreeSet<Integer> t = new TreeSet<Integer>();
		HashSet<Integer> h = new HashSet<Integer>();
		
		int x=30, y=5,z=18;
		
		a.add(x);
		a.add(y);
		a.add(z);
		
		l.add(x);
		l.add(y);
		l.add(z);
		
		t.add(x);
		t.add(y);
		t.add(z);

		h.add(x);
		h.add(y);
		h.add(z);
		
		for(int i = 0; i < 3; i++)
		{
			System.out.println(a.get(i));
			System.out.println(l.get(i));
		}
		
		Iterator<Integer> itr = t.iterator();
		Iterator<Integer> itr2 = h.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		while(itr2.hasNext())
		{
			System.out.println(itr2.next());
		}
		
		System.out.println("---------------------------------------");
		System.out.println("Before sort");
		System.out.println(a);
		System.out.println(l);
		System.out.println(t);
		System.out.println(h);
		
		Collections.sort(a);
		Collections.sort(l);
		//treeset is auto-sorted
		
		ArrayList<Integer> list = new ArrayList<Integer>(h);
		Collections.sort(list);
		//System.out.println(list);
		//HashSet hSorted =  new HashSet(list);
		//no direct way to sort hashset
		//hashSet does not preserve order, so you cannot sort a HashSet
		
		System.out.println("------------After sort");
		System.out.println(a);
		System.out.println(l);
		System.out.println(t);
		System.out.println(list);
		
	}

}
