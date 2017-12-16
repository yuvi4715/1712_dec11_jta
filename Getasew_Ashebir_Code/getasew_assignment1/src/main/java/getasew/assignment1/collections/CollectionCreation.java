package getasew.assignment1.collections;

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

public class CollectionCreation {
	public static void main(String[] args) {
		createCollections();

	}
	static void createCollections() {
		List<String> alist = new ArrayList<String>();
		List<String> llist = new LinkedList<String>();
		HashMap<String,Integer>	hm = new HashMap<String,Integer>();
		Set<String> hset = new HashSet<String>();
		Set<String> tset = new TreeSet<String>();
		//adding objects to the ArrayList
		alist.add("milk");
		alist.add("egg");
		alist.add("sugar");
		//adding objects the LinkedList
		llist.add("milk");
		llist.add("egg");
		llist.add("sugar");
		//adding contents to the HashMap
		hm.put("Dan",25);
		hm.put("Luke",29);
		hm.put("Jerry", 34);
		//adding objects the HashSet
		hset.add("milk");
		hset.add("egg");
		hset.add("sugar");
		//adding objects the TreeSet
		tset.add("milk");
		tset.add("egg");
		tset.add("sugar");
		//Display objects from the ArrayList
		System.out.println("ArrayList: ");
		for(String a: alist) {
			System.out.printf("%s ", a);
		} 
		//Display contents of the LinkedList
		System.out.println(" ");
		System.out.println("LinkedList: ");

		for(String l: llist) {
			System.out.printf("%s ",l);
		}
		//Displaying the HashMap
		System.out.println(" ");
		System.out.println("HashMap");
		Set s = hm.entrySet();// copy the entries of the map to the set 
		Iterator it = s.iterator();//get the iterator for the set
		while(it.hasNext()){ //iterate over the Map entries
			Map.Entry me = (Map.Entry)it.next();
			System.out.println("key: ="+me.getKey()+"  value ="+me.getValue());
			 
		}
		System.out.println(" ");
		System.out.println("HashSet: ");

		for(String h: hset) {
			System.out.printf(" %s ",h);

		}
		System.out.println(" ");
		System.out.println("TreeSet: ");

		for(String t: tset) {
			System.out.printf("%s ", t);
		}
		// Sorting contents of collections
		Collections.sort(alist);
		Collections.sort(llist);
		System.out.println(" ");
		System.out.println("------Displaying after Sorting-----");
		System.out.println("ArrayList: ");
		for(String a: alist) {
			System.out.printf("%s ", a);
		} 
		//Display contents of the LinkedList
		System.out.println(" ");
		System.out.println("LinkedList: ");

		for(String l: llist) {
			System.out.printf("%s ",l);
		}
		System.out.println(" ");
		System.out.println("HashSet: ");

		for(String h: hset) {
			System.out.printf(" %s ",h);

		}
		System.out.println(" ");
		System.out.println("TreeSet: ");

		for(String t: tset) {
			System.out.printf("%s ", t);
		}



	}
}

