package EasyCoding;

import java.util.Scanner;

/**
 * Name: Stephen Oduor
 * Date: 12/12/2017
 * Question: Write a program called GradeStatistics, which reads in n grades (of int between 0 and 100, inclusive)
 *           and display the average, minimum, maximum, and standard deviation. Your program shall check for for valid
 *           input. You should keep the grades in an int[] and use a method for each of the computation.
 */

public class GradeStatistics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 3;
        int input;
        int[] grades = new int[n];

        System.out.println("Enter " + n + " grades between 0 and 100 ");

        for (int i = 0; i < n; i++) {

            if(i > 0) {
                System.out.println("Enter " + (n - i) + " grades between 0 and 100 ");
            }

            input = scanner.nextInt();

            if(input > 100 || input < 0){
                System.out.println("Re-input number between 0 and 100");
                i--;
            }else {
                grades[i] = input;
            }

        }


        System.out.println("Standard deviation: " + standardDeviation(grades));
        System.out.println("Average: " + average(grades));
        System.out.println("max: " + max(grades));
        System.out.println("min: " + min(grades));


    }

    //Calculate standardDeviation

    public static double standardDeviation(int[] grades){
        int tmp = 0;
        double tmpMean = 0;
        int i = 0;
        int[] tmpArray = new int[grades.length];
        double mean = average(grades);//work out the mean


        for(int grade : grades){
            tmpArray[i] =(int) Math.pow((grade - mean), 2);
            i++;
        }

        tmpMean = average(tmpArray);

        return Math.pow((tmpMean), 0.5);
    }


    public static double average(int[] grades){
        int sum = 0;

        for(int grade :  grades){
            sum = sum + grade;
        }

        return sum / grades.length;
    }


    public static int max(int[] grades){
        int max = grades[0];

        for(int grade: grades){
            if(grade > max){
                max = grade;
            }
        }
        return max;
    }

    public static int min(int[] grades){
        int min = grades[0];

        for(int grade: grades){
            if(grade < min){
                min = grade;
            }
        }
        return min;
    }




}
