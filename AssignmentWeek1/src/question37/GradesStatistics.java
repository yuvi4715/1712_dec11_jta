package question37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

public class GradesStatistics {
	LinkedList<Integer> grades = new LinkedList<Integer>();

	int input = 0;
	
	public void getGrades() throws IOException {
		InputStreamReader r = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(r);
		
		System.out.println("Please enter your test scores. Numbers above 100 or below 0 will be omitted.");
		
		String[] keystrokes = br.readLine().split(" ");
		int temp = 0;
		
		for(int i = 0; i < keystrokes.length; i++) {
			temp = Integer.parseInt(keystrokes[i]);
			if(temp <= 100 && temp >= 0) {
				grades.add(temp);
			}
		}
		Collections.sort(grades);
	}
	
	public void computeMinimum() {
		System.out.println("Min: " + grades.getFirst());//put in min
	}
	
	public void computeMaximum() {
		System.out.println("Max: " + grades.getLast()); //put in max
	}
	
	public double computeAverage() {
		int temp = 0;//do some averaging stuff
		for(int i = 0; i < grades.size(); i++) {
			temp += grades.get(i);
		}
		double average = (double)temp / grades.size();
		System.out.println("Avg: " + average);
		return average;
	}
	
	public void computeStDev() {
		double average = computeAverage();
		double variance = 0;
		 for(int i = 0; i < grades.size(); i++) {
			 variance += Math.pow(grades.get(i) - average, 2);
		 }
		 variance /= (grades.size() - 1);
		 double stDev = Math.sqrt(variance);
		 System.out.println("Standard Deviation " + stDev);
	}

}
