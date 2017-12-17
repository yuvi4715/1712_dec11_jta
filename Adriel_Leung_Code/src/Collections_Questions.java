import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;

public class Collections_Questions {
	
	
	public static void main(String[] args) {
		//Question 21
		Integer i1 = 1;
		Integer i2 = 2;
		Integer i3 = 3;
		
		List<Integer> al = new ArrayList<Integer>();
		al.add(i3);
		al.add(i2);
		al.add(i1);
		
		List<Integer> ll = new LinkedList<Integer>();
		ll.add(i3);
		ll.add(i2);
		ll.add(i1);
		
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(i3);
		set1.add(i2);
		set1.add(i1);
		
		Set<Integer> set2 = new TreeSet<Integer>();
		set1.add(i3);
		set1.add(i2);
		set1.add(i1);
		
		//Question 22
		System.out.println("Values of ArrayList");
		for (int i: al){
			System.out.println(i);
		}
		System.out.println("Values of LinkedList");
		for (int i: ll){
			System.out.println(i);
		}
		System.out.println("Values of HashSet");
		for (int i: set1){
			System.out.println(i);
		}
		System.out.println("Values of TreeSet");
		for (int i: set2){
			System.out.println(i);
		}
		
		//Question 23
		System.out.println("Sorting ArrayList");
		Collections.sort(al);
		System.out.println("Values of ArrayList");
		for (int i: al){
			System.out.println(i);
		}
		System.out.println("Sorting sortedLinkedList");
		Collections.sort(ll);
		System.out.println("Values of sorted LinkedList");
		for (int i: ll){
			System.out.println(i);
		}
		System.out.println("The Integers in the sorted ArrayList and LinkedList are in ascending order now");
		System.out.println("HashSet cannot be sorted as it is a collection of key value pairs");
		System.out.println("TreeSet cannot be sorted because sorting is handled upon object insertion");
		//Collections.sort(set1);
		//Collections.sort(set2);
		
		
		
		
			
	}
	
	
}
