package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Problem21to23 {

	public static void main(String[] args) {
		
		List<Integer> arraylist = new ArrayList<Integer>();
		List<Character> linkedlist = new LinkedList<Character>();
		Map<Integer, String> hashmap = new HashMap<Integer, String>();
		HashSet<String> hashset = new HashSet<String>();
		Set<Integer> treeset = new TreeSet<Integer>();

        arraylist.add(55);
        arraylist.add(35);
        arraylist.add(70);
        
        linkedlist.add('G');
        linkedlist.add('A');
        linkedlist.add('R');
        
        hashmap.put(2002, "Matt");
        hashmap.put(2003, "Point Rider Lane");
        hashmap.put(2004, "Dornoch Drive");
        
        //Student s1 = new Student("Alabama", "Mike", 201);
        //Student s2 = new Student("Delaware", "Dave", 202);
        //Student s3 = new Student("Maine", "Mary", 203);
       
        //hashset.add(s1);
        //hashset.add(s2);
        //hashset.add(s3);
       
        hashset.add("Susan");
        hashset.add("Richard");
        hashset.add("Woody");
        
       // Student s4 = new Student("Indiana", "Susan", 204);
        //Student s5 = new Student("Montana", "Burt", 205);
        //Student s6 = new Student("New Mexico", "Jordan", 206);
        
        
        treeset.add(32);
        treeset.add(23);
        treeset.add(23);
        treeset.add(47);
        
        System.out.println("The unsorted ArrayList: ");
        for(Integer integer: arraylist) {
        	System.out.println(integer);
        }
        System.out.println("The unsorted LinkedList: "); 
        for(Character character: linkedlist) {
        	System.out.println(character);
        }
        System.out.println("The unsorted HashMap key value pairs:");
        for(Map.Entry<Integer, String> entry : hashmap.entrySet()) {
        	System.out.println("Key: " + entry.getKey() + " and Value: " + entry.getValue());
        	
        }
        System.out.println("The unsorted Hashset: ");
        for(String string: hashset) {
        	System.out.println(string);
        }
        System.out.println("The sorted Treeset: ");
        for(Integer integer2: treeset) {
        	System.out.println(integer2);
        }
        
        Collections.sort(arraylist);
        System.out.println("ArrayList elements in sorted order: " + arraylist);
        Collections.sort(linkedlist);
        System.out.println("LinkedList elements in sorted order: " + linkedlist);
        List<String> tempList = new ArrayList<String>(hashset);
        Collections.sort(tempList);
        System.out.println("HashSet elements in sorted order: " + tempList);
        List<Integer> tempList2 = new ArrayList<Integer>(treeset);
        Collections.sort(tempList2);
        System.out.println("TreeSet elements in sorted order: " + tempList2);
        List keys = new ArrayList(hashmap.keySet());
        List values = new ArrayList(hashmap.values());
        Collections.sort(keys);
        Collections.sort(values);
        System.out.println("HashMap in sorder order: " + keys + values);

        
	}

}
