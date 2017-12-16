package com.revature.week1.Collections;

import java.util.*;

public class TreeSetTest {

	public static void main(String[] args) {

		// Creating the treeset
		Set<Dog> dogs = new TreeSet<Dog>();

		// creating the three objects
		Dog d1 = new Dog("Lassie", 10);
		Dog d2 = new Dog("Scooby Doo", 25);
		Dog d3 = new Dog("Snoopy", 5);

		// Added the three obecjts to the treeset
		dogs.add(d1);
		dogs.add(d2);
		dogs.add(d3);

		// The list is already sorted so you do not have to sort
		for (Dog dog : dogs) {
			System.out.println(dog.getName() + " " + dog.getAge());
		}
	}
}
