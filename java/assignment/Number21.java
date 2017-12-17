package com.revature.day1;
import java.util.*;
import java.util.stream.Collectors;

public class Number21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Array list
		ArrayList theList = new ArrayList();
		
		theList.add("A");
		theList.add("C");
		theList.add("B");
		
		Iterator<String> f = theList.iterator();
		while (f.hasNext())
			System.out.println(f.next()); 
		
		Collections.sort(theList);
		
		System.out.println("after sorting");
		Iterator<String> f2 = theList.iterator(); //print again after sorting collection
		while (f2.hasNext())
			System.out.println(f2.next()); 
		
		
		
		//Linked list
		LinkedList<String> linkedlist = new LinkedList<String>();
		
		linkedlist.add("Thing2");
		linkedlist.add("Thing1");
		linkedlist.add("Thing3");
		
		for(String str: linkedlist)
		{
			System.out.println(str);
		}
		
Collections.sort(linkedlist);
		
		System.out.println("after sorting");
		Iterator<String> f3 = linkedlist.iterator(); //print again after sorting collection
		while (f3.hasNext())
			System.out.println(f3.next());
		
		
		
		
		//Hashmap
		HashMap<Integer,String> theHash = new HashMap<Integer,String>();
		
		theHash.put(100, "apples");
		theHash.put(101, "pears");
		theHash.put(102, "Oranges");
		
		System.out.println("Iterating over list:");
		for (HashMap.Entry<Integer, String> entry : theHash.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(value);
		}
		
		
		System.out.println("after sorting");
		
		List keys = new ArrayList(theHash.keySet());
		
		Collections.sort(keys);
		
		for (HashMap.Entry<Integer, String> entry : theHash.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println(value);
		}
		
		
		
		
		//Treeset
		TreeSet MySet = new TreeSet();
		
		MySet.add("C");
		MySet.add("A");
		MySet.add("B");
		
		System.out.println("Iterating over list:");
		Iterator<String> h = MySet.iterator();
		while (h.hasNext())
			System.out.println(h.next());
		
		TreeSet set = new TreeSet(new Comparator<String>() { //I do not understand this!
			public int compare(String o1, String o2) {
				String n1 = o1.split(" ")[1];
				String n2 = o2.split(" ")[1];
				return Integer.parseInt(n2) - Integer.parseInt(n1);
			}
			public boolean equals(String o1, String o2) {
				return compare(o1, o2)==0;
			}
		});
		
		
		 
		
		
		
		//Hashset
		HashSet<String> HSet = new HashSet(); // more work needed here
		
		HSet.add("two");
		HSet.add("three");
		HSet.add("one");
		
		System.out.println("Iterating over list:");
		Iterator<String> i = HSet.iterator();
		while (i.hasNext())
			System.out.println(i.next());
		
	} 

}
