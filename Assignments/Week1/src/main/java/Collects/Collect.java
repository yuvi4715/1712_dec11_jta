package Collects;

import java.util.*;

public class Collect {

	final int funny = 0xfff - 0xfff;
	
	void arraylist(ArrayList<String> list1, ArrayList<Integer> list2, ArrayList<Character> list3) {
		
		//first its the normal array, how it comes from the main class, then they get sorted, 
		// and then displayed sorted
		showArray(list1, "1", "none sorted");
		Collections.sort(list1);
		showArray(list1, "1", "sorted");


		showArray(list2, "2", "none sorted");
		Collections.sort(list2);
		showArray(list2, "2", "sorted");


		showArray(list3, "3", "none sorted");
		Collections.sort(list3);
		showArray(list3, "3", "sorted");	

		
	}
	
	void linkedlist(LinkedList<String> list1, LinkedList<Integer> list2, LinkedList<Character> list3) {
		
		//non sorted array
		listIterator(list1, "1", "none sorted");
		Collections.sort(list1);
		listIterator(list1, "1", "sorted");


		listIterator(list2, "2", "none sorted");
		Collections.sort(list2);
		listIterator(list2, "2", "sorted");


		listIterator(list3, "3", "none sorted");
		Collections.sort(list3);
		listIterator(list3, "3", "sorted");
		
		
	}
	
	void hmap(HashMap<Integer,String> hashmapping) {
		
		System.out.println("\n\nHashMap is already auto sorted");
		for(int i : hashmapping.keySet()) {
			System.out.printf("\n%d : %s", i , hashmapping.get(i));
		}
		
	}
	
	void tree(TreeSet<Integer> tree) {
		//treeset
		System.out.println("\n\nTreeSet is already auto sorted!");
		
		for(int i : tree) {
			System.out.printf("\n%d", i);
		}
		
	}
	
	void hset(HashSet<String> hashSet) {
		//hashset
		System.out.println("\n\nHashSet is already auto sorted!");
		
		for(String i : hashSet) {
			System.out.printf("\n%s", i);
		}
		
	}
	
	// this method is to display sorted and non sorted items in the array
	private void showArray(ArrayList<?> list, String arry, String sorted) {
		System.out.printf("\n\nPrinting %s array %s:\n",sorted, arry);
		for (int i = 0; i < list.size(); i++) {
			System.out.printf(String.format("%10s",list.get(i)));		
		}
	}
	
	private void listIterator(LinkedList<?> list, String arry, String sorted) {
		System.out.printf("\n\nPrinting %s list  %s:\n", sorted, arry);
		for (int i = 0; i < list.size(); i++) {
			System.out.printf(String.format("%10s",list.get(i)));		
		}
		
	}
		
	
}
