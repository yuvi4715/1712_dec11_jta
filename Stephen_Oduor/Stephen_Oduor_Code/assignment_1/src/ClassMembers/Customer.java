package ClassMembers;

import java.util.Calendar;

public class Customer {

    final double DISCOUNT = 2;
    int birth_year = 0;
    static int customerId = 0;
    double rewardPoints = 0;
    int rewardCardNum ;
    String name;
    boolean member , veteran;


    public Customer(String name, boolean veteran, int birth_year){
        customerId++;
        this.veteran = member;
    }

    public Customer(String name, boolean member, boolean veteran, int birth_year){
        this.name = name;
        this.rewardCardNum = rewardCardNum;
        this.member = member;
        this.veteran = veteran;
        this.birth_year = birth_year;
        customerId++;
    }

    //calculate birth year
    public int calculateAge(int birth_year){
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.YEAR) - birth_year;
    }



    //reward if member
    public void addRewardPoints(double rewardPoints, boolean member){
        if(member) {
            this.rewardPoints = rewardPoints + (rewardPoints * DISCOUNT);
        }
        else{
            rewardPoints = 0;
        }
    }

    //reward if member
    public void addRewardPoints(double rewardPoints, boolean member, boolean veteran){
        if(member || veteran){
            this.rewardPoints = rewardPoints + (rewardPoints * DISCOUNT);
        }else {
            rewardPoints = 0;
        }
    }

    //Return the total number of Customers created
    public static int totalCustomers(){
        return customerId;
    }

    public int getCustomerId(){
        return customerId;
    }

    public double getRewardPoints(){
        return rewardPoints;
    }

}
