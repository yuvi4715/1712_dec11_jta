package com.revature.fileio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamExample {

	ObjectInputStream ois = null;
	ObjectOutputStream oos = null;
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		new ObjectInputOutputStreamExample().serializePerson(new Person());
		new ObjectInputOutputStreamExample().deserializePerson();
	}
	
	void serializePerson(Person p) throws FileNotFoundException, IOException {
		oos = new ObjectOutputStream(new FileOutputStream("src\\main\\resources\\ObjectStream.txt"));
		oos.writeObject(p);
		oos.close();
	}
	
	void deserializePerson() throws FileNotFoundException, IOException, ClassNotFoundException {
		ois = new ObjectInputStream(new FileInputStream("src\\main\\resources\\ObjectStream.txt"));
		Person p1 = (Person) ois.readObject();
		System.out.println(p1.getAge());
		System.out.println(p1.getDOB());
		System.out.println(p1.getName());
		System.out.println(p1.getSsn());
		ois.close();
	}

}
