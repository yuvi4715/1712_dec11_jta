package getasew.assignment1.easycoding;
/*
 * 37.Write a program called GradesStatistics, which reads
 * in n grades (of int between 0 and 100, inclusive) and
 * displays the average, minimum, maximum, and standard deviation.
 * Your program shall check for valid input.
 * You should keep the grades in an int[] and use a method 
 * for each of the computations.

 */
public class GradesStatistics {

	public static void main(String[] args) {
		int[] a = {25, 75,89,90, 60, 50, 45,78,69};
		// TODO Auto-generated method stub
		calculateStastics(a);

	}
	static void calculateStastics(int [] grade) {
		if((grade.length<0)&& (grade.length>100)) {
			System.out.println("incorrect number of grades");
			System.exit(0);
			
		}
		double average;
		int min=grade[0], max=0;
		double sd;
		double sumsq = 0;
		int sum = 0;
		for(int i=0; i< grade.length;i++) {
			sum +=  grade[i];
			if(max < grade[i]) {
				max = grade[i];
			}
			if(min > grade[i]) {
				min = grade[i];
			}
		}
		average = (sum/grade.length);
		for(int j=0;j<grade.length;j++) {
			sumsq += Math.pow((grade[j]-average), 2);
		}
		sd = Math.sqrt(sumsq/grade.length);
		
		System.out.printf("Maximum = %d%n",max);
		System.out.printf("Minimum = %d%n",min);
		System.out.printf("average = %f%n",average);
		System.out.printf("Standard deviation= %f%n",sd);

	}

}
