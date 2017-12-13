package EasyCodingExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class GradeStatistics {

	/*
	 * Write a program called GradesStatistics, 
	 * which reads in n grades (of int between 0 and 100, inclusive) 
	 * and displays the average, minimum, maximum, and standard deviation. 
	 * Your program shall check for valid input. 
	 * You should keep the grades in an int[] and use a method for each of the computations.
	 * 
	 * found sum, found average, found min max
	 * */
	
	private static ArrayList<Double> grades = new ArrayList<Double>();
	private static double sum = 0;
	private static double average = 0;
	private static double sdeviation = 0;
	private static BufferedReader bufreader;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sum of the grades for now is 772, unless changed

		readGrades("src/main/resources/Grades.txt");
		
		getGrades();
		
		

		
	}
	
	//method to read the file and parse the numbers if available
	private static void readGrades(String file) {
		String line = null;
		try {
			FileReader reader = new FileReader(file);
			bufreader = new BufferedReader(reader);
			
			while ((line = bufreader.readLine()) != null) {
				if(intTryParse(line)) {
					grades.add(Double.parseDouble(line));
				}	
				else {
					System.out.println("Input: " + "[ "+ line + " ]"+  " is not a valid number, so its being skipped!");
				}
			}
		} catch (Exception e) {
			// I AM PURFECT
			System.out.println("Error at: "+ e.getMessage());
		}	
	}
	
	private static void getGrades() {
		
		for(double i : grades) {
			sum = sum + i;
		}
		average = sum / grades.size();
		sdeviation = Math.sqrt(average);
		System.out.println("The sum of all the grades is: "+ sum);
		System.out.println("The average of all the grades is : " + average);
		Collections.sort(grades);
		System.out.println("The highest grade is: " + grades.get(grades.size() - 1));
		System.out.println("The lowest grade is: " +  grades.get(0));
		System.out.println("The standard deviation is: " + sdeviation);
		
	}
	
	private static boolean intTryParse(String number) {
		try {
			Double.parseDouble(number);
			return true;
		} catch (Exception e) {
			return false;
			// TODO: handle exception
		}
	}

}
