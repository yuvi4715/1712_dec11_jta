package AdvancedCoding;

import java.util.Calendar;

/**
 * Name: Stephen Oduor
 * Date: 12/14/2017
 * Question: 39
 * Description: Write a method to take a date of birth via Calendar object and returns your age
 *              If its your age print the happy birthday song
 *
 */

public class Birthday {

    public static void main(String[] args){
        Calendar dob = new Calendar() {
            @Override
            protected void computeTime() {

            }

            @Override
            protected void computeFields() {

            }

            @Override
            public void add(int field, int amount) {

            }

            @Override
            public void roll(int field, boolean up) {

            }

            @Override
            public int getMinimum(int field) {
                return 0;
            }

            @Override
            public int getMaximum(int field) {
                return 0;
            }

            @Override
            public int getGreatestMinimum(int field) {
                return 0;
            }

            @Override
            public int getLeastMaximum(int field) {
                return 0;
            }
        };

        dob.set(1994,11,14);

        System.out.println(age(dob));
    }




    public static int age(Calendar dob){
        int age;
        Calendar currentCal = Calendar.getInstance();
        int currentYear = currentCal.get(Calendar.YEAR);

        if((dob.get(Calendar.MONTH) == currentCal.get(Calendar.MONTH)) &&
                (dob.get(Calendar.DAY_OF_MONTH) == currentCal.get(Calendar.DAY_OF_MONTH))){

            System.out.println("Happy birthday to you, happy birthday to you!");
        }
        
        age = currentYear - dob.get(Calendar.YEAR);
        return age;
    }


}

