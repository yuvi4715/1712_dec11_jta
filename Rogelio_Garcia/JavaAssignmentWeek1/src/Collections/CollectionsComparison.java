package Collections;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

// 21, 22, 23
public class CollectionsComparison {
	class Comparator {
		
	}
	public static void main(String[] args) {
		Integer one = new Integer(3);
		Integer two = new Integer(1);
		Integer three = new Integer(2);
		Iterator<Integer> itr;
		
		System.out.println("Arraylist");
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.add(one);
		arrList.add(two);
		arrList.add(three);
		itr = arrList.iterator();
		while (itr.hasNext()) System.out.print(itr.next());
		System.out.println();
		Collections.sort(arrList);
		itr = arrList.iterator();
		while (itr.hasNext()) System.out.print(itr.next());
		System.out.println();
		
		System.out.println("linkedlist");
		LinkedList<Integer> linkedList = new LinkedList<>();
		linkedList.add(one);
		linkedList.add(two);
		linkedList.add(three);
		itr = linkedList.iterator();
		while (itr.hasNext()) System.out.print(itr.next());
		System.out.println();
		Collections.sort(linkedList);
		itr = linkedList.iterator();
		while (itr.hasNext()) System.out.print(itr.next());
		System.out.println();

		System.out.println("hashmap");
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(1, one);
		hashMap.put(2, two);
		hashMap.put(3, three);
		for (Integer value: hashMap.values()) {
			System.out.print(value);
		}
		System.out.println();
		
		System.out.println("treeset");
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(one);
		treeSet.add(two);
		treeSet.add(three);
		itr = treeSet.iterator();
		while (itr.hasNext()) System.out.print(itr.next());
		System.out.println();
		// Collections.sort(treeSet);
		// Tree set is sorted already, backed by a balanced BST
		itr = treeSet.iterator();
		while (itr.hasNext()) System.out.print(itr.next());
		System.out.println();

		System.out.println("hashset");
		HashSet<Integer> hashSet = new HashSet<>();
		hashSet.add(one);
		hashSet.add(two);
		hashSet.add(three);
		itr = hashSet.iterator();
		while (itr.hasNext()) System.out.print(itr.next());
		System.out.println();
		itr = hashSet.iterator();
		while (itr.hasNext()) System.out.print(itr.next());
		System.out.println();

		
		
	}
}
