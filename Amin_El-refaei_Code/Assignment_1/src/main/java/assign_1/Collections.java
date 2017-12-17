package assign_1; //This class contains the code for numbers 21-23

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class Collections {

	public static void main(String[] args) {
		arrayList(); // statically calling arrayList method

		System.out.println("---------------"); // just a line to separate outputs

		linkedList(); // statically calling linkedList method

		System.out.println("---------------"); // just a line to separate outputs

		hashMap(); // statically calling hashMap method

		System.out.println("---------------"); // just a line to separate outputs

		treeSet(); // statically calling treeSet method

		System.out.println("---------------"); // just a line to separate outputs

		hashSet(); // statically calling hashSet method
	}

	public static void arrayList() {
		ArrayList<String> friends = new ArrayList<String>(); // created new ArrayList of type String called friends

		friends.add("Jeffrey"); // added Jeffrey to the ArrayList
		friends.add("Zack");
		friends.add("Doug");

		System.out.println("This is my unsorted ArrayList:");

		for (int x = 0; x < friends.size(); x++) // for loop which iterates through the ArrayList and prints all objects
													// on a separate line
			System.out.println(friends.get(x));

		System.out.println(); // blank line

		System.out.println("This is my sorted ArrayList:");

		friends.sort(null); // sorting the ArrayList
		for (int y = 0; y < friends.size(); y++) // for loop which iterates through the ArrayList and prints all sorted
													// objects on a separate line
			System.out.println(friends.get(y));
	}

	public static void linkedList() {
		LinkedList<String> roomies = new LinkedList<String>(); // created a LinkedList of type String called roomies

		roomies.add("Tony"); // added Tony to the LinkedList
		roomies.add("Tuan");
		roomies.add("Jason");

		System.out.println("This is my LinkedList: ");

		for (int x = 0; x < roomies.size(); x++) // for loop which iterates through the LinkedList and prints all
													// objects on a separate line
			System.out.println(roomies.get(x));

		System.out.println(); // blank line

		System.out.println("This is my sorted LinkedList:");

		roomies.sort(null); // sorting the LinkedList
		for (int y = 0; y < roomies.size(); y++) // for loop which iterates through the sorted LinkedList and prints all
													// objects on a separate line
			System.out.println(roomies.get(y));
	}

	public static void hashMap() {
		HashMap<Integer, String> hm1 = new HashMap<Integer, String>(); // created a HashMap of type Integer, String
																		// called hm1
		hm1.put(001, "Java"); // added Java to the HashMap with key 001
		hm1.put(002, "C++");
		hm1.put(003, "Python");

		System.out.println("This is my HashMap: ");

		for (Entry<Integer, String> entry : hm1.entrySet()) { // for loop which iterates through the HashMap and prints
																// all objects on a separate line
			int key = entry.getKey();
			String b = entry.getValue();
			System.out.println(key + ". " + b);
		}

		System.out.println(); // blank line

		HashMap<Integer, String> sorted = new HashMap<>(hm1);
		Set<Entry<Integer, String>> mappings = sorted.entrySet(); // sorting the HashMap

		System.out.println("This is my sorted HashMap: ");
		for (Entry<Integer, String> mapping : mappings) { // for loop which iterates through the sorted HashMap and
															// prints all objects on a separate line
			System.out.println(mapping.getKey() + ". " + mapping.getValue());
		}

	}

	public static void treeSet() {
		TreeSet<String> ts1 = new TreeSet<String>(); // created a TreeSet of type String called ts1
		ts1.add("Eclipse"); // added Eclipse to the TreeSet
		ts1.add("Bloodshed");
		ts1.add("STS");

		System.out.println("This is my TreeSet: ");

		Iterator<String> it1 = ts1.iterator(); // created an iterator to use with the while loop to iterate through the
												// TreeSet
		while (it1.hasNext()) { // while loop which iterates through the TreeSet and prints all objects on a
								// separate line
			String c = it1.next();
			System.out.println(c);
		}

		// TreeSet is already sorted by nature.
	}

	public static void hashSet() {
		HashSet<String> hs1 = new HashSet<String>(); // created a HashSet of type String called hs1
		hs1.add("Apples"); // added Apples to the HashSet
		hs1.add("Bananas");
		hs1.add("Oranges");

		System.out.println("This is my HashSet: ");

		Iterator<String> it1 = hs1.iterator(); // created an iterator to use with the while loop to iterate through the
												// HashSet
		while (it1.hasNext()) { // while loop which iterates through the HashSet and prints all objects on a
								// separate line
			String c = it1.next();
			System.out.println(c);
		}

	}
}
