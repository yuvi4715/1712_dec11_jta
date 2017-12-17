package com.revature.ece;

/*
 * Nathan Poole
 * Question Thirty-seven
 * Write a program called GradesStatistics, which reads in n grades 
 * 		(of int between 0 and 100, inclusive) and displays the average, 
 * 		minimum, maximum, and standard deviation. Your program shall 
 * 		check for valid input. You should keep the grades in an int[] 
 * 		and use a method for each of the computations.
 */


public class GradesStatistics {
	
	int[] MyGrades;
		
	public static void main(String[] args) {
		GradesStatistics SomeGrades = new GradesStatistics();
		SomeGrades.setGrades(args);
		System.out.println(SomeGrades.average());
		System.out.println(SomeGrades.minimum());
		System.out.println(SomeGrades.maximum());
		System.out.println(SomeGrades.stdDeviation());
		
	}

	private double stdDeviation() {
			double temp = 0 ,avg = average();
			int denominator = 0;
			for(int i: MyGrades) {
				temp += Math.pow((i-avg), 2);
				denominator++;
			}
			return Math.sqrt(temp/denominator);
		
	}

	private int maximum() {
		int max = MyGrades[0];
		for(int i: MyGrades) {
			if( i > max ) max = i;
		}
		return max;
	}

	private int minimum() {

		int min = MyGrades[0];
		for (int i: MyGrades) {
			if(i < min) min = i;
		}
		return min;
	}

	private double average() {

		int total = 0;
		int denominator = 0;
			for( int i: MyGrades) {
				total += i;
				denominator++;
			}
		return ((double)total/denominator);
	}

	private void setGrades(String[] grades) {
		int i = 0;
		MyGrades = new int[grades.length];
		for(String num: grades) {
			//System.out.println(num);
			MyGrades[i++] = Integer.parseInt(num);
			}
	}
}
