package Collects;

import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Collect collect = new Collect();

		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Character> list3 = new ArrayList<Character>();
		LinkedList<String> linked1 = new LinkedList<>();
		LinkedList<Integer> linked2 = new LinkedList<>();
		LinkedList<Character> linked3 = new LinkedList<>();

		
		list1.add("Hello");
		list1.add("World");
		list1.add("How");
		list1.add("Are");
		list1.add("You?");
		
		list2.add(1);
		list2.add(10);
		list2.add(35);
		list2.add(9);
		list2.add(7);
		
		list3.add('a');
		list3.add('c');
		list3.add('f');
		list3.add('b');
		list3.add('z');
		
		
		
		collect.arraylist(list1, list2, list3);
		
		linked1.addFirst("Linked");
		linked1.addLast("List");
		linked1.add("Rogelio");
		linked1.add("Jose");
		linked1.add("William");
		linked1.add("Robin");
		
		linked2.add(10);
		linked2.add(50);
		linked2.add(6);
		linked2.add(3);
		linked2.add(8);
		
		linked3.add('k');
		linked3.add('r');
		linked3.add('h');
		linked3.add('b');
		linked3.add('f');
		
		collect.linkedlist(linked1, linked2, linked3);
		
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		
		hmap.put(2, "William");
		hmap.put(3, "Rogelio");
		hmap.put(5, "Yuvi");
		hmap.put(1, "Jose");
		hmap.put(4, "Robin");
		
		collect.hmap(hmap);
		
		TreeSet<Integer> tree = new TreeSet<Integer>();
		
		tree.add(1);
		tree.add(5);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		
		collect.tree(tree);
		
		HashSet<String> hashSet = new HashSet<String>();
		
		hashSet.add("Oh");
		hashSet.add("Mcdonald");
		hashSet.add("Had");
		hashSet.add("A");
		hashSet.add("Farm");
		
		collect.hset(hashSet);
		
	
		
	}

}
