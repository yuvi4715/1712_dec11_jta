package FileIO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

// 24 - 28
public class EmployeeIO {
	public static void main(String[] args) {
		HashMap<Integer, Employee> hm = new HashMap<>();
		try {
			File f = new File("./src/FileIO/EmployeeData");
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String readLine = "";
			while ((readLine = reader.readLine()) != null) {
				String[] data = readLine.split(":");
				Integer id = new Integer(data[0]);
				Employee temp = new Employee(id, data[1], data[2], data[3]);
				hm.put(id, temp);
			}
			reader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		for (Employee emp: hm.values()) {
			System.out.println(emp);
		}
	}
}
