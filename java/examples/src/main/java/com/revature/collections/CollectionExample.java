package com.revature.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;


/**
 * Collections is an utility class
 * 
 * @author yuvarajd
 *
 */
public class CollectionExample {
	public static void main(String[] args) {
		//new CollectionExample().SampleList();
		//new CollectionExample().otherExamples();
		new CollectionExample().mapExample();
	}
	void SampleList() {
		//after 1.5 it is not required to do type casting after Generics were introduced
		List <Integer> list = new ArrayList<>();
		//List<Integer> list2 = new List<>();
		list.add(124);
		list.add(35);
		list.add(31);
		list.add(214);
		list.add(45);
		list.add(67);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		//int x = list.get(2);
		System.out.println("value of 3rd item " + list.get(2));
		
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		//list.toArray();
	}
	
	void otherExamples() {

		List<Integer> list = new LinkedList<>();			//only has access to methods from List
		Deque<Integer> deque = new LinkedList<>();			//Deque
		Queue<Integer> Queue = new LinkedList<>();			//Queue
		LinkedList<Integer> Link = new LinkedList<>();		//LinkedList
		Stack <Integer> st = new Stack<>();
		Set <Integer> set1 = new HashSet<>();
		Set <Integer> set2 = new TreeSet<>();
		
		Queue.add(1);
		Queue.add(2);
		Queue.add(3);
		Queue.add(4);
		Queue.add(5);
		System.out.println(Queue);
		Queue.poll();
		System.out.println(Queue);
		Queue.peek();
		System.out.println(Queue);
		
		st.add(10);
		st.add(20);
		System.out.println(st);
		st.pop();
		System.out.println(st);
		
		
	}
	
	void mapExample() {
		
		//Map<K, V> m4 = new HashMap<Integer, String>();
		
		Map<Integer, String> m1 = new HashMap<>();
		//Map<Integer, String> m2 = new Hashtable<>();
		Map<Integer, String> m3 = new TreeMap<>();
		
		m1.put(10, "Ten");
		m1.put(20, "twenty");
		m1.put(30, "thirty");
		m1.put(null, "Null");
		m1.put(null, "Null2");
		m1.put(null, "Null3");
		System.out.println(m1);
		m1.remove(null);
		
		m3.putAll(m1);
		System.out.println(m3);
		
		for (Entry<Integer, String> e: m3.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}

}








