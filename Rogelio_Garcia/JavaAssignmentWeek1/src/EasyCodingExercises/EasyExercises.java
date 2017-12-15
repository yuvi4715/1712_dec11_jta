package EasyCodingExercises;
import java.util.Scanner;
public class EasyExercises {
	// 32
	public static void checkPassFail(int mark) {
		if (mark >= 50) System.out.println("PASS");
		else System.out.println("FAIL");
	}
	// 33
	public static void checkOddEven(int number) {
		if (number % 2 == 0) System.out.println("Even Number");
		else System.out.println("Odd Number");
	}
	// 34
	public static void printNumberInWord(int number) {
		switch(number) {
		case 1: System.out.println("ONE");break;
		case 2: System.out.println("TWO");break;
		case 3: System.out.println("THREE");break;
		case 4: System.out.println("FOUR");break;
		case 5: System.out.println("FIVE");break;
		case 6: System.out.println("SIX");break;
		case 7: System.out.println("SEVEN");break;
		case 8: System.out.println("EIGHT");break;
		case 9: System.out.println("NINE");break;
		default:System.out.println("OTHER");break;
		}
	}
	// 35
	public static void keyboardScanner() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter an int");
		int i = sc.nextInt();
		System.out.println("Enter an double");
		double d = sc.nextDouble();
		System.out.println("Enter a String");
		String s = sc.next();
		System.out.println("int: " + i + " double: " + d + " String: " + s);
	}
	// 36
	public static void arithmetic(int a, int b, String c) {
		switch(c) {
		case "+": System.out.println(a + b); break;
		case "-": System.out.println(a - b); break;
		case "*": System.out.println(a * b); break;
		case "/": System.out.println(a / b); break;
		default:  System.out.println("unrecognized operator");
		}
	}
	// 37
	public static void gradesStatistics(int n) {
		Scanner sc = new Scanner(System.in);
		int[] grades = new int[n];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			grades[i] = sc.nextInt();
			if (grades[i] > max) max = grades[i];
			if (grades[i] < min) min = grades[i];
		}
		sc.close();
		double mean = 0;
		for (int i = 0; i < grades.length; i++) {
			mean += grades[i];
		}
		mean /= n;
		double std = 0;
		for (int i = 0; i < grades.length; i++) {
			std +=(grades[i] - mean) * (grades[i] - mean);
		}
		std /= n;
		std = Math.sqrt(std);
		System.out.println("Average: " + mean + " Minimum: " + min + " Maximum: " + max + " Standard Deviation: " + std);
	}
	public static void main(String[] args) {
		checkOddEven(12);
		printNumberInWord(234);
		keyboardScanner();
		if (args.length != 0)
			arithmetic(new Integer(args[0]), new Integer(args[1]), args[2]);
		gradesStatistics(5);
		
		
	}
}
