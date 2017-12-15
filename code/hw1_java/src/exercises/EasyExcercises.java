package exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class EasyExcercises {
	public void CheckPassFail(int mark) {	//#32
		if (mark >= 50)
			System.out.println("PASS");
		else
			System.out.println("FAIL");
	}
	
	public void CheckOddEven(int num) { //#33
		if (num % 2 == 0) 
			System.out.println("Even Number");
		else
			System.out.println("Odd Number");
	}
	
	public void PrintNumberinWord(int num) { //#34
		String str = null;
		if (num < 10 && num > 0) {
			switch(num) {
			case 1:
				str = "ONE"; break;
			case 2:
				str = "TWO"; break;
			case 3:
				str = "THREE"; break;
			case 4:
				str = "FOUR"; break;
			case 5:
				str = "FIVE"; break;
			case 6:
				str = "SIX"; break;
			case 7:
				str = "SEVEN"; break;
			case 8:
				str = "EIGHT"; break;
			case 9:
				str = "NINE"; break;
			}
		}
		else {
			str = "OTHER";
		}
		System.out.println(str);
	}
	
	public void KeyboardScanner() {	//#35
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter an integer:");
		int i = keyboard.nextInt();
		System.out.println("Enter a double:");
		double d = keyboard.nextDouble();
		System.out.println("Enter a string:");
		String str = keyboard.next();
		
		System.out.printf("Integer: %d\n"
				+ "Double: %f\n"
				+ "String: %s", i, d, str);
		keyboard.close();
	}
	
	public void Arithmetic() {	//#36 does NO error checking
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter two numbers and an operator(+ - * /)(delimited by spaces):");
		String input = keyboard.nextLine();
		StringTokenizer st = new StringTokenizer(input);
		String sa = st.nextToken();
		String sb = st.nextToken();
		String op = st.nextToken();
		int a = Integer.parseInt(sa);
		int b = Integer.parseInt(sb);
		int c = 0;
		
		
		switch(op) {
		case "+":
			c = a + b; break;
		case "-":
			c = a - b; break;
		case "*":
			c = a * b; break;
		case "/":
			c = a / b; break;
		}
		
		String output = sa + " " + op + " " + sb + " = " + c;
		System.out.println(output);
		keyboard.close();
	}
	
	public void GradeStatistics() {
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter grades (0-100 delimited by spaces):");
		String input = kb.nextLine();
		
		int size = 0;
		for(int i = 0; i < input.length(); i++) {
		  if(Character.isWhitespace(input.charAt(i))) size++;
		}
		int[] arr = new int[size+1];
		
		int idx = 0;
		int min = 100, max = 0, sum = 0;
		double mean = 0;
		
		StringTokenizer st = new StringTokenizer(input);
		while(st.hasMoreTokens()) {
			int grade = Integer.parseInt(st.nextToken());
			
			if(grade < min) {
				min = grade;
			}
			if(grade > max) {
				max = grade;
			}
			sum += grade;
			arr[idx++] = grade;
		}
		
		mean = (double)sum / (double) arr.length;
		
		//standard deviation = sqrt{ sum[(num-mean)^2] / size }
		double varSum = 0;
		for(int i = 0; i < arr.length; i++) {
			varSum += Math.pow((arr[i] - mean), 2);
		}
		double variance = varSum / arr.length;	//variance of set
		double stddev = Math.sqrt(variance);
		
		System.out.println(Arrays.toString(arr));
		System.out.printf("Min: %d\n"
				+ "Max: %d\n"
				+ "Mean: %f\n" 
				+ "Standard Deviation: %f\n", min, max, mean, stddev);
	}
}
