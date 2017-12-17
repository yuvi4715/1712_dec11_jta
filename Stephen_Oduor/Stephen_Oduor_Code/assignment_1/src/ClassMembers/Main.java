package ClassMembers;



public class Main {

    public static void main(String[] args){
        Customer c1 = new Customer("Stephen", false, 1994);
        Customer c2 = new Customer("John", true, true, 1921);
        c2.addRewardPoints(45,true, true);

        System.out.println("Number of customers: " + Customer.totalCustomers());
        System.out.println("C1 age: " + c1.calculateAge(1994));
        System.out.println("C2 id: " + c2.getCustomerId());
        System.out.println("C2 reward points: " +  c2.getRewardPoints());


    }

}
