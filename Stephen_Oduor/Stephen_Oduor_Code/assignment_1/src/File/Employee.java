package File;

public class Employee {

    String employeeId;
    String firstName;
    String lastName;
    String role;

    public Employee(String employeeId, String firstName, String lastName, String role){

        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public String toString(){
        return employeeId + " " + firstName + " " + lastName + " " + role;
    }



}
