package File;
/**
 * Name: Stephen Oduor
 * Date: 12/14/2017
 * Question: 24,25,26,27,28
 * Description: Text file has the following colon-separated lines
 *              Employee:id:firstName:lastName:role
 *              Read the file and parse(tokenize) the fields using StringTokenizer with delimeter(:)
 *              While parsing the file, place the information in an object, which should have four instance variables
 *              Employee Id, FirstName, LastName, Role
 *              Place these objects in a HashMap with key as employee id and value as object.
 */

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class ReadFile {

    public static void main(String[] args){
        File file = new File("src\\File\\file.txt");
        HashMap<String, Employee> employeeHashMap = new HashMap<>();
        String employeeInfo[];
        Scanner scanner = null;
        Employee employee;

        try {
            scanner= new Scanner(file);
            while(scanner.hasNextLine()){
                employeeInfo = scanner.next().split(":");

                employee = new Employee(employeeInfo[0], employeeInfo[1], employeeInfo[2], employeeInfo[3]);
                employeeHashMap.put(employee.employeeId, employee);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            scanner.close();
        }

        System.out.println(employeeHashMap.toString());

    }


}
