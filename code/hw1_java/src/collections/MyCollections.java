package collections;

import java.util.*;

public class MyCollections {
	public void createCollections() {	//#21
		List<Integer> al = new ArrayList<Integer>(3);	//init size 3
		al.add(1);
		al.add(2);
		al.add(3);
			
		List<String> ll = new LinkedList<String>();
		ll.add("item1");
		ll.add("item2");
		ll.add("item3");
		
		HashMap<String, Integer> m = new HashMap<String, Integer>(3);
		m.put("k1", 1);
		m.put("k2", 2);
		m.put("k3", 3);
		
		TreeSet<Integer> t = new TreeSet<Integer>();
		t.add(75);
		t.add(50);
		t.add(25);
		
		HashSet<Integer> s = new HashSet<Integer>();
		s.add(200);
		s.add(100);
		s.add(300);
		
		for (int i: al) System.out.println(i);	//#22
		for (String i: ll) System.out.println(i);
		for (String k: m.keySet()) System.out.println(k + " " + m.get(k));
		for (int i: t) System.out.println(i);
		for (int i: s) System.out.println(i);
		
		List<Integer> alSorted = new ArrayList<Integer>(al);
		Collections.sort(alSorted);		//#23 list gets sorted 
		
		List<String> llSorted = new LinkedList<String>(ll);
		Collections.sort(llSorted);		//linked list gets sorted
		
		//TreeSet already sorted...
		
		List<Integer> sSorted = new ArrayList<Integer>(s);
		Collections.sort(sSorted);		//hashset gets sorted but really no point in sorting a set...
	}
}
