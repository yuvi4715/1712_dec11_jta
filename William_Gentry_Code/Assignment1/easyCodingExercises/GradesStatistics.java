package easyCodingExercises;

public class GradesStatistics {

	private int[] grades;
	
	public GradesStatistics(int[] grades) {
		this.grades = grades;
		if (this.validateGrades()){
			System.out.println("Input grades are valid.");
			System.out.println("Sample Mean: " + this.average());
			System.out.println("Maximum: " + this.maximum());
			System.out.println("Minimum: " + this.minimum());
			System.out.println("Sample Standard Deviation: " + this.sampleStandardDeviation());
			System.out.println("Sample Variance: " + this.sampleVariance());
		} else {
			System.out.println("Input grades are not valid!");
		}
			
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
	
	public boolean validateGrades() {
		boolean gradesAreValid = true;
		for (int i = 0; i < this.grades.length; i++) {
			if (this.grades[i] < 0 || this.grades[i] > 100) {
				return false;
			} 
		}
		return gradesAreValid;
	}
	
	public double sampleVariance() {
		final double sampleMean = this.average();
		double sumOfTerms = 0;
		for (int i = 0; i < this.grades.length; i++) {
			double currentTerm = (this.grades[i] - sampleMean);
			sumOfTerms += Math.pow(currentTerm, 2);
		}
		return sumOfTerms / (this.grades.length - 1);
	}
	
	public double sampleStandardDeviation() {
		final double sampleMean = this.average();
		final int denominator = this.grades.length - 1;
		double sumOfTerms = 0;
		for (int i = 0; i < this.grades.length; i++) {
			double currentTerm = (this.grades[i] - sampleMean);
			sumOfTerms += Math.pow(currentTerm, 2);
		}
		double sampleVariance = sumOfTerms / denominator;
		return Math.sqrt(sampleVariance);
	}
	
	public static void main(String[] args) {
		GradesStatistics test = new GradesStatistics(new int[] {1, 2, 4, 5, 10});
		
	}
}
