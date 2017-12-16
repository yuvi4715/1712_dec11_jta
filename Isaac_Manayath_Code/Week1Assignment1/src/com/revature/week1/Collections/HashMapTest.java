package com.revature.week1.Collections;

import java.util.*;

public class HashMapTest {

	public static void main(String[] args) {

		// Creating the hashmap
		Map<Integer, Dog> dogs = new HashMap<Integer, Dog>();

		// Created three objects
		Dog d1 = new Dog("Lassie", 10);
		Dog d2 = new Dog("Scooby Doo", 25);
		Dog d3 = new Dog("Snoopy", 5);

		// Adding three objects to the hashmap
		dogs.put(d1.getAge(), d1);
		dogs.put(d2.getAge(), d2);
		dogs.put(d3.getAge(), d3);

		// Printing out the map entries
		for (Map.Entry<Integer, Dog> entry : dogs.entrySet()) {
			int key = entry.getKey();
			Dog d = entry.getValue();
			System.out.println(d.getName() + " " + d.getAge());
		}

		// Not yet sorted
		List<Dog> DogByAge = new ArrayList<Dog>(dogs.values());

		// Sorting the map
		Collections.sort(DogByAge, new Comparator<Dog>() {

			public int compare(Dog d1, Dog d2) {
				return d1.getAge() - d2.getAge();
			}
		});

		// Printing out the list
		System.out.println();
		for (Dog d : DogByAge) {
			System.out.println(d.getName() + " " + d.getAge());
		}

	}
}
