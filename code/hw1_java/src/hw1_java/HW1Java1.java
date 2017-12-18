package hw1_java;

import core.Core;
import classmembers.Customers;
import oop.*;
import exceptions.*;
import advancedconcepts.*;
import collections.MyCollections;
import fileio.FileIO;
import multithreading.Multithreading;
import exercises.*;
import bonus.Bonus;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HW1Java1 {
	public static void main(String[] args) {
		//coreCall();
		//CustomersCall();
		//oopCall();
		//exceptionCall();
		//advancedCall();
		//collectionsCall();
		//fileioCall();
		//multithreadingCall();
		//excercisesCall();
		bonusCall();
	}
	
	public static void coreCall() {
		Core c = new Core();
		c.core1();
		c.core2();
		c.core3();
	}
	
	public static void CustomersCall() {
		Customers c1 = new Customers();
		Customers c2 = new Customers(2, 3);
		c1.add();
		c2.add(4);
	}
	
	public static void oopCall() {
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		one.eat();	//human eats
		one.move();	//move does nothing
		System.out.println();
		two.eat();	//human eats
		two.move();	//move does nothing
		Mammal.walk();	//mammal walks
		System.out.println();
		three.eat();	//human eats
		three.move();	//move does nothing
		Human.walk();	//human walks
		
	}
	
	public static void exceptionCall() {	
		TestCustomException tce = new TestCustomException();
		tce.test(1, 2);
	}
	
	public static void advancedCall() {
		Strings s = new Strings();
		s.stringEdit("test string");
		s.stringToken("pickles:ketchup:mustard:onion");
		s.stringadd("20", "25");
		
		Runtime rt = java.lang.Runtime.getRuntime();	//#20 gets info about classes, current jvm etc...
		rt.availableProcessors(); // number of processors available to the JVM
		rt.totalMemory();		//returns total amount of mem avail to JVM
		rt.exit(0);				//terminates current JVM
	}
	
	public static void collectionsCall() {
		MyCollections c = new MyCollections();
		c.createCollections();
	}
	
	public static void fileioCall() {
		String cwd = System.getProperty("user.dir");	//cwd
		String filename = "testfile.txt";
		String filepath = cwd + "\\" + filename;
		
		try {
			new FileIO().fileparse(filepath);
		}
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	public static void multithreadingCall() {
		Multithreading t1 = new Multithreading("t1");
		Multithreading t2 = new Multithreading("t2");
		Multithreading t3 = new Multithreading("t3");
		t1.start();				
		t2.start();
		t3.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			System.out.println("Done");
		}
		catch (Exception e) {
			System.out.println("Interrupt Exception");
		}
	}
	
	public static void excercisesCall() {
		EasyExcercises ee = new EasyExcercises();
		/*ee.CheckPassFail(49);
		ee.CheckOddEven(51);
		ee.PrintNumberinWord(1);*/
		
		//ee.KeyboardScanner();
		//ee.Arithmetic();
		//ee.GradeStatistics();
		
		HardExcercises he = new HardExcercises();
		//he.stringReplace();
		//he.getAge();
		//he.fibonacciIteration();
		//System.out.println(he.fibonacciRecursion(10));
		//he.fizzbuzz();
		//he.compareEmployees();
		//he.reverseString("Hello World");
		//System.out.println(he.checkPrime(97));
		System.out.println(he.checkArmstrong(153));
	}
	
	public static void bonusCall() {
		Bonus b = new Bonus();
		String str = "The dog jumped over the fence. eeeeeeeeee";
		String word = "Hello World";
		int[] arr = new int[] {5, 3, 9, 2, 4, 7, 8, 1, 2}; 
		int[] a1 = new int[] {1, 2, 3, 4, 5};
		int[] a2 = new int[] {2, 5, 7, 8, 10};
		
		
		b.intswap();
		b.findMidNode();
		System.out.println(b.Factorial(5));
		System.out.println(b.substring("Hello World", 4, 6));
		//b.deadlock();
		//b.livelock();
		b.reverseNum(123456789);
		b.findDuplicate();
		b.findRepeatWords();
		b.findRepeatChars(str);
		b.checkOddEven(101);
		b.isPalindrome(word);
		b.sortInsertion(arr);
		b.findCommon(a1, a2);
		b.findDistinct(arr);
		b.findDistinctWords();
		b.computePi();
		b.printDog();
		b.printPascals();
		b.numGuess();
	}


}
