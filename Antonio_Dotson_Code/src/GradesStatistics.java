import java.util.Arrays;
//Antonio Dotson 
public class GradesStatistics {
	//Problem 37
	// create variables to hold the int value and the array values
	int n;
    int [] grades;
    // Equation to get the Standard deviation of numbers
    /* created variables to hold the sum , average, squaring and square root of the array.
     * and the return the correct value for deviation.
     */
	public double getStandard (int n, int[]grades ) {
	int sum = 0;
	double averagex =0;
	for(int x=0; x< grades.length; x++) {
		sum += grades[x];
	}
	double average = sum/n;
    for (int x=0; x<grades.length; x++) {
    	averagex += Math.pow((grades[x]-average),2);
    }
      double newAve = averagex/n;
      double newnewAve = Math.sqrt(newAve);
      return newnewAve;
    	
	}
		/*
		 *  Use the median equation (n+1)/2 to get the median. Used array sort to get correct order of index
		 *  and used the equation on the index, converted the index value to an integer and returned the number. 
		 */
	
	public int getMedian (int n, int [] grades) {
		Arrays.sort(grades);
		int len = n-1;
	    int ent = (len + 1) / 2;
	    int medians = Integer.valueOf(grades[ent]);
	    return medians;   
	}
	// standard formula for get the average of numbers- ran it through a loop to get the values 
	/* sum up the values and divided by the number of array elements
	 * 
	 */
	public double getAverage (int n, int [] grades) {
		int sum = 0;
		for(int x=0; x< grades.length; x++) {
			sum += grades[x];
			
		}
		double average = sum/n;
	    return average;
	}
			// Used array sort to sort grades from high and low and used 0 for the lowest index number.
	
	public int getMin (int [] grades) {
		Arrays.sort(grades);
	    int grade = Integer.valueOf(grades[0]);
	    return grade;	
	}  
	  // used array sort to get the sorting of indexes from low to high and used the last index number. 
	public int getMax (int n, int [] grades) {
		int len = n -1;
		Arrays.sort(grades);
		int grade = Integer.valueOf(grades[len]);
	    return grade;
		
	}
	public static void main(String[] args) {
		// create array and values and then call the class and print the methods
		int numberofValues = 7;
		int[] newArray = {50,20,30,40,10,99,43};
		GradesStatistics newGrades = new GradesStatistics();
		int max = newGrades.getMax(numberofValues, newArray);    
		int min = newGrades.getMin(newArray);
		double standard = newGrades.getStandard(numberofValues, newArray);
        double avg  = newGrades.getAverage(numberofValues, newArray);
        int median =  newGrades.getMedian(numberofValues, newArray);
        System.out.println("The average of your grades are " + avg);
        System.out.println("The max of your grades is " + max);
        System.out.println("The min of your grades is "  + min);
        System.out.println("The median of your grades is " + median);
        System.out.println("The standard deviation of your grades is " +standard);
	}
	 
}
