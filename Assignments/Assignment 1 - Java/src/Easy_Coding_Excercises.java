import java.util.Scanner;

public class Easy_Coding_Excercises {
	public static class CheckPassFail {
		public static void check(int mark) {
			if (mark >= 50) {
				System.out.println("PASS");
			} else {
				System.out.println("FAIL");
			}
		}
	}

	public static class CheckOddEven {
		public static void OddOrEven(int number) {
			if (number % 2 == 1) {
				System.out.println("Odd Number");
			} else {
				System.out.println("Even Number");
			}
		}
	}

	public static class PrintNumberInWord {
		public static void NestedIf(int number) {
			if (number <= 9) {
				if (number == 1) {
					System.out.println("ONE");
				} else if (number == 2) {
					System.out.println("TWO");
				} else if (number == 3) {
					System.out.println("THREE");
				} else if (number == 4) {
					System.out.println("FOUR");
				} else if (number == 5) {
					System.out.println("FIVE");
				} else if (number == 6) {
					System.out.println("SIX");
				} else if (number == 7) {
					System.out.println("SEVEN");
				} else if (number == 8) {
					System.out.println("EIGHT");
				} else if (number == 9) {
					System.out.println("NINE");
				}
			} else {
				System.out.println("OTHER");
			}
		}
		public static void SwitchCase(int number) {
			switch (number) {
			case 1:
				System.out.println("ONE");
				break;
			case 2:
				System.out.println("TWO");
				break;
			case 3:
				System.out.println("THREE");
				break;
			case 4:
				System.out.println("FOUR");
				break;
			case 5:
				System.out.println("FIVE");
				break;
			case 6:
				System.out.println("SIX");
				break;
			case 7:
				System.out.println("SEVEN");
				break;
			case 8:
				System.out.println("EIGHT");
				break;
			case 9:
				System.out.println("NINE");
				break;
			default:
				System.out.println("OTHER");
				break;
			}
			
		}
	}
	public static class KeyboardScanner{
		public static void Scan() {
			Scanner scanner = new Scanner( System.in );
			String input;
			
		    System.out.print("Please enter an int");
		    input = scanner.nextLine();
		    System.out.println("You entered: " + input);
		    
		    System.out.print("Please enter a double");
		    input = scanner.nextLine();
		    System.out.println("You entered: " + input);
		    
		    System.out.print("Please enter a String");
		    input = scanner.nextLine();
		    System.out.println("You entered: " + input);
		}
	}
	
	public static class Arithmetic{
		public static void Compute(String arg1,String arg2,String arg3) {
			int a = Integer.parseInt(arg1);
			int b = Integer.parseInt(arg2);
			char c = arg3.charAt(0);
			
			int result = 0;
			
			if (c == '+') {
				result = a + b; 
			}
			else if (c == '-') {
				result = a - b; 
			} 
			else if (c == '*') {
				result = a * b; 
			}
			else if (c == '/') {
				result = a / b; 
			}
			
			System.out.println("The answer is: " + result);
		}
	}
	
	public static class GradesStatistics{
		public static void Compute(int[] grades, int n) {
			int grades_to_read = checkGradesSize(grades, n);
			if (isValid(grades, grades_to_read)){
				printAve(grades, grades_to_read);
				printMin(grades, grades_to_read);
				printMax(grades, grades_to_read);
				printStdDev(grades, grades_to_read);
			}
			else {
				System.out.println("Invalid input");
			}
		}
		//find amount of grades to read; 
		//   is n if there are at least n grades to read
		public static int checkGradesSize(int[] grades, int n) {
			int amount = 0;
			if (n > grades.length) {
				amount = grades.length; 
			}
			else {
				amount = n;
			}
			return amount;
		}
	
		public static boolean isValid(int[] grades, int n) {
			
			for (int i = 0; i < n; i++) {
				if (grades[i] < 0 || grades[i] > 100) {
					return false;
				}
			}
			return true;
		}
		
		public static void printAve(int[] grades, int n) {
			int total = 0;
			for (int i = 0; i < n; i++) {
				total += grades[i];
			}
			System.out.println("The average is: " + total / n);
		}
		
		public static void printMin(int[] grades, int n) {
			int current_min = grades[0];
			for (int i = 0; i < n; i++) {
				if (grades[i] < current_min) {
					current_min = grades[i];
				}
			}
			System.out.println("The minimum is: " + current_min);
		}
		
		public static void printMax(int[] grades, int n) {
			int current_max = grades[0];
			for (int i = 0; i < n; i++) {
				if (grades[i] > current_max) {
					current_max = grades[i];
				}
			}
			System.out.println("The maximum is: " + current_max);
		}
		
		public static void printStdDev(int[] grades, int n) {
			//find average
			int total = 0;
			int average = 0;
			for (int i = 0; i < n; i++) {
				total += grades[i];
			}
			average = total / n;
			//subtract average from each grade, square,
			//   and sum them all up
			int diff = 0;
			int total_diffs = 0;
			for (int i = 0; i < n; i++) {
				diff = average - grades[i];
				total_diffs += diff * diff;
			}
			//square root everything
			double stddev = Math.sqrt(total_diffs);
			System.out.println("The standard deviation is: " + stddev);;
		}
	}
	
	public static void main(String[] args) {
		CheckPassFail.check(55);
		CheckOddEven.OddOrEven(7);
		PrintNumberInWord.NestedIf(7);
		PrintNumberInWord.SwitchCase(8);
		//KeyboardScanner is called last so everything else can print first
		Arithmetic.Compute("12", "17", "+");
		
		int[] grade_scores = {70, 95, 55, 100, 25, 90};
		GradesStatistics.Compute(grade_scores, 5);
		
		KeyboardScanner.Scan();
		
		
	}
}
