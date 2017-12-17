package part10_EasyExercises;

public class GradesStatistics {

	private int[] grades;

	// Constructor
	public GradesStatistics(int[] grades) {
	
		this.grades = grades;
		
		if (this.validateGrades()){
			System.out.println("Maximum: " + this.maximum());
			System.out.println("Minimum: " + this.minimum());
			System.out.println("Mean: " + this.average());
			System.out.println("Standard Deviation: " + this.standardDeviation());
		} else {
			System.out.println("Entered grades are invalid!");
		}
		
	}

	public static void main(String[] args) {
		
		GradesStatistics test = new GradesStatistics(new int[] {70, 86, 95, 73, 60, 88, 82, 85, 90, 67});
	}
	
	public boolean validateGrades() {
		
		boolean validGrades = true;
		
		for (int i = 0; i < this.grades.length; i++) {
			if (this.grades[i] < 0 || this.grades[i] > 100) {
				return false;
			} 
		}
		
		return validGrades;
	}
	
	public double average() {
	
		double sum = 0;
		
		for (int i = 0; i < this.grades.length; i++) {
			sum += grades[i];
		}
		
		return (double) sum / grades.length;
	}
	
	public int minimum() {
	
		int min = this.grades[0];
		
		for (int i = 1; i < this.grades.length; i++) {
			if (min > this.grades[i]) {
				min = this.grades[i];
			}
		}
		return min;
	}
	
	public int maximum() {
		
		int max = this.grades[0];
		
		for (int i = 1; i < this.grades.length; i++) {
			if (max < this.grades[i]) {
				max = this.grades[i];
			}
		}
		
		return max;
	}
	
	public double standardDeviation() {
		
		final double sampleMean = this.average();
		final int deno = this.grades.length - 1;
		double sum = 0;
		
		for (int i = 0; i < this.grades.length; i++) {
			double current = (this.grades[i] - sampleMean);
			sum += Math.pow(current, 2);
		}
		
		double variance = sum / deno;
		
		return Math.sqrt(variance);
	}
	
}
