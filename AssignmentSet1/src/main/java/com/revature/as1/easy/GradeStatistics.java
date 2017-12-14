package com.revature.as1.easy;

import com.revature.as1.KeyboardInputScanner;

public class GradeStatistics {
	
	public static void main(String[] args) {
		KeyboardInputScanner kis = new KeyboardInputScanner();
		
		int numGrades = -1;
		
		while(numGrades < 0) {
			System.out.println("Enter a positive number of grades.");
			numGrades = kis.setIntArgs();
		}
		
		int[] grades = kis.setIntArgs(numGrades);
		
		float avg = average(grades);
		
		if(avg == -1f) {
			System.out.println("Invalid grade input. Grades must be between 0 and 100.");
			System.exit(0);
		}
		
		System.out.println("The average of entered grades is: " + avg);
		System.out.println("The minimum of entered grades is: " + minimum(grades));
		System.out.println("The maximum of entered grades is: " + maximum(grades));
		System.out.println("The standard deviation of entered grades is: " + sd(grades));
		
		
	}
	
	public static float average(int[] grades) {
		//returns -1 if an invalid grade is passed
		int sum = 0;
		for(int i = 0; i < grades.length; i++) {
			if(grades[i] < 0 || grades[i] > 100) {
				return -1;
			}else {
				sum += grades[i];
			}
			
		}
		
		return sum/(float)grades.length;
	}
	
	public static int minimum(int[] grades) {
		//returns -1 if an invalid grade is passed
		int minimum = -1;
		for(int i = 0; i < grades.length; i++) {
			if(grades[i] < 0 || grades[i] > 100) {
				return -1;
			}else {
				if(minimum != -1) {
					if(minimum > grades[i]) {
						minimum = grades[i];
					}
				}else {
					minimum = grades[i];
				}
			}
			
		}
		
		return minimum;
	}
	
	public static int maximum(int[] grades) {
		//returns -1 if an invalid grade is passed
		int max = -1;
		for(int i = 0; i < grades.length; i++) {
			if(grades[i] < 0 || grades[i] > 100) {
				return -1;
			}else {
				if(max != -1) {
					if(max < grades[i]) {
						max = grades[i];
					}
				}else {
					max = grades[i];
				}
			}
			
		}
		
		return max;
	}
	
	public static double sd(int[] grades) {
		//returns -1 if an invalid grade is passed
		float avg = average(grades);
		
		int variance = -1;
		for(int i = 0; i < grades.length; i++) {
			if(grades[i] < 0 || grades[i] > 100) {
				return -1;
			}else {
				variance += Math.pow(grades[i]-avg,2);
			}
			
		}
		
		return Math.sqrt(variance/grades.length);
	}

}
