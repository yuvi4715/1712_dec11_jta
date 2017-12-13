package easyCodingExercises;

public class EasyCodingExercises37 {

	public static void main(String[] args) {
		/*
		 * Write a program called GradesStatistics, which reads in n grades (of int
		 * between 0 and 100, inclusive) and displays the average, minimum, maximum, and
		 * standard deviation. Your program shall check for valid input. You should keep
		 * the grades in an int[] and use a method for each of the computations.
		 */
		GradesStatistics(65,72,81,58,90);
	}

	private static void GradesStatistics(int... grades) {
		if (checkValidInput(grades)) {
			System.out.println("The average grade was " + getAvgGrade(grades));
			System.out.println("The minimum grade was " + getMinGrade(grades));
			System.out.println("The maximum grade was " + getMaxGrade(grades));
			System.out.println("The standard deviation of grades was " + getStdDevOfGrade(grades));
		} else {
			System.err.println("Your grade input was incorrect (must be valid integer grades)");
		}
	}

	public static boolean checkValidInput(int[] grades) {
		for (int grade : grades) {
			if (grade < 0 || grade > 100)
				return false;
		}
		return true;
	}

	public static float getAvgGrade(int[] grades) {
		int sum = 0;
		for (int grade : grades) {
			sum += grade;
		}
		return sum / grades.length;
	}

	public static int getMinGrade(int[] grades) {
		int min = grades[0];
		for (int grade : grades) {
			if (grade < min)
				min = grade;
		}
		return min;
	}

	public static int getMaxGrade(int[] grades) {
		int max = grades[0];
		for (int grade : grades) {
			if (grade > max)
				max = grade;
		}
		return max;
	}

	public static float getStdDevOfGrade(int[] grades) {
		float mean = getAvgGrade(grades);
		float sumOfSqDiff = 0;
		float variance;
		for (int grade : grades) {
			float diff = (grade - mean);
			sumOfSqDiff += Math.pow(diff, 2d);
		}
		variance = sumOfSqDiff / grades.length;
		return (float) Math.sqrt(variance);
	}

}
